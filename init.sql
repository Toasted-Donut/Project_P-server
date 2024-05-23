SET NAMES 'utf8mb4';
SET sql_mode='NO_AUTO_VALUE_ON_ZERO';
CREATE DATABASE IF NOT EXISTS appDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE appDB;

CREATE TABLE IF NOT EXISTS category (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS product (
  name VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  category_id INT NOT NULL,
  foreign key (category_id) references category (id),
  PRIMARY KEY (NAME)
);

ALTER TABLE category AUTO_INCREMENT=0;

INSERT INTO category (id,name) VALUES (0,"Другое");
INSERT INTO category (name) VALUES
    ("Молочная продукция"),
    ("Сыры"),
    ("Овощи"),
    ("Фрукты"),
    ("Хлеб"),
    ("Выпечка"),
    ("Сладости"),
    ("Макароны"),
    ("Соусы и приправы"),
    ("Колбасные изделия"),
    ("Полуфабрикаты"),
    ("Яйца"),
    ("Вода"),
    ("Соки"),
    ("Газировка");