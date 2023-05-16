INSERT INTO news_source (name)
VALUES ('BBC News'), ('CNN'), ('The New York Times');

INSERT INTO news_topic (name)
VALUES ('Sport'), ('Cyber-sport'), ('Politics'), ('Technologies');

INSERT INTO news (title, content, publish_date, source_id, topic_id)
VALUES ('Football Champions League', 'Sensational lose for Barcelona', '2023-05-14 23:50:00', 1, 1),
       ('ESL Berlin Major', 'Crisis of Team Spirit', '2023-05-14 23:50:00', 1, 2),
       ('Politics1', 'politics-content1', '2023-05-14 23:50:00', 1, 3),
       ('OpenAI', 'new version of ChatGPT will be announced soon', '2023-05-14 23:50:00', 1, 1),
       ('Football World Cup', 'The FIFA World Cup is the biggest event in football.', '2023-06-10', 1, 1),
       ('E-sports Tournament', 'The international e-sports tournament showcased top gamers from around the world.', '2023-07-15', 2, 2),
       ('Election Results', 'The election results are in, and the new government has been elected.', '2023-05-01', 3, 3),
       ('New Smartphone Release', 'A new smartphone with advanced features and improved performance has been launched.', '2023-09-20', 3, 4),
       ('Basketball Championship', 'The annual basketball championship concluded with an exciting final match.', '2023-08-05', 1, 1),
       ('Cybersecurity Breach', 'A major cybersecurity breach exposed sensitive data of millions of users.', '2023-07-30', 2, 4),
       ('Political Scandal Uncovered', 'A political scandal involving high-ranking officials has been uncovered.', '2023-06-25', 3, 3),
       ('Latest Technological Advancements', 'Discover the latest technological advancements revolutionizing various industries.', '2023-09-05', 1, 4),
       ('Tennis Grand Slam', 'The prestigious tennis Grand Slam event saw fierce competition among top-ranked players.', '2023-07-20', 2, 1),
       ('Rise of E-sports', 'E-sports continue to grow in popularity, attracting a global audience and big sponsors.', '2023-08-10', 3, 2),
       ('Government Policy Announcement', 'The government announced new policies aimed at economic growth and social welfare.', '2023-06-15', 1, 3),
       ('Breakthrough in Renewable Energy', 'Scientists achieve a major breakthrough in renewable energy generation.', '2023-09-10', 2, 4);