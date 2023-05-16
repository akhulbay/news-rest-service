CREATE DATABASE news_repository;

CREATE TABLE news_source (
                             id SERIAL PRIMARY KEY ,
                             name VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE news_topic (
                            id SERIAL PRIMARY KEY ,
                            name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE news (
                      id BIGSERIAL PRIMARY KEY ,
                      title VARCHAR(256) NOT NULL ,
                      content TEXT NOT NULL ,
                      publish_date TIMESTAMP,
                      source_id INT REFERENCES news_source (id) ON DELETE CASCADE ,
                      topic_id INT REFERENCES news_topic (id) ON DELETE CASCADE
);

CREATE TABLE _user (
                       id BIGSERIAL PRIMARY KEY ,
                       firstname VARCHAR(256) ,
                       lastname VARCHAR(256) ,
                       email VARCHAR(256) UNIQUE NOT NULL ,
                       password VARCHAR(256) NOT NULL ,
                       role VARCHAR(256) NOT NULL
);