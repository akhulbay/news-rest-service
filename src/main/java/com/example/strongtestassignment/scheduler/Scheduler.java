package com.example.strongtestassignment.scheduler;

import com.example.strongtestassignment.entity.NewsSource;
import com.example.strongtestassignment.repository.NewsRepository;
import com.example.strongtestassignment.repository.NewsSourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final NewsRepository newsRepository;
    private final NewsSourceRepository newsSourceRepository;

    @Scheduled(cron = "@midnight")
    public void scheduler() {
        List<NewsSource> newsSources = newsSourceRepository.findAll();
        writeNote(getNewsNumber(newsSources), getTime());
    }

    private String getTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return localDateTime.format(formatter);
    }

    private Map<String, Integer> getNewsNumber(List<NewsSource> newsSources) {
        return newsSources.stream()
                .collect(Collectors.toMap(
                        NewsSource::getName,
                        newsSource -> newsRepository
                                .countNewsByNewsSource_Id(newsSource.getId())
                ));
    }

    private void writeNote(Map<String, Integer> map, String time) {
        Path path = Path.of("src", "main", "resources", "records", "record.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            writer.write(time);
            writer.newLine();
            map.forEach((key, value) -> {
                try {
                    writer.write(String.format("%s: %d", key, value));
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
