# 1. go get the json file from glitch
# 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

# 3. create the movies_db

# 4. use the movies_db

# 5. drop the table(s) to which no other tables are dependent (none at first)

# 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties

# 6a. Run the script to make sure it works

# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!
DROP DATABASE IF EXISTS movies_db;
CREATE DATABASE IF NOT EXISTS  movies_db;
USE movies_db;

DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;

CREATE TABLE directors (
id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,
name VARCHAR(255)
);

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

DESC movies;


