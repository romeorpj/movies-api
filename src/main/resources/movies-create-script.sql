

# 1. go get the json file from glitch

# 2. copy paste into a new json file under /resources

# 3. create the movies_db

# 4. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties

create database if not exists movies_db;

use movies_db;

drop table if exists movie_genre;
drop table if exists movie_actor;
drop table if exists actors;
drop table if exists genres;
drop table if exists movies;
drop table if exists directors;


create table if not exists directors
(
    id int unsigned not null auto_increment primary key,
    name varchar(120)
);

DESC directors;


CREATE TABLE IF NOT EXISTS movies (
id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(120) NOT NULL,
director_id INT UNSIGNED NOT NULL,
actors VARCHAR(255),
plot TEXT,
rating CHAR(1),
year VARCHAR(4) NOT NULL,
genre VARCHAR(120),
poster VARCHAR(255),
FOREIGN KEY (director_id) REFERENCES directors(id)
);

describe movies;


create table if not exists genres
(
    id   int unsigned not null auto_increment primary key,
    name varchar(120)
);

DESC genres;


create table if not exists movie_genre
(
    movie_id int unsigned not null,
    genre_id int unsigned not null,
    foreign key (movie_id) references movies(id),
    foreign key (genre_id) references genres(id)

);

DESC movie_genre;

create table if not exists actors
(
    id int unsigned not null auto_increment primary key,
    name varchar(255)
);

DESCactors;

create table if not exists movie_actor
(
    movie_id int unsigned not null,
    actor_id int unsigned not null,
    foreign key (movie_id) references movies (id),
    foreign key (actor_id) references actors (id)
);

DESC movie_actor;
