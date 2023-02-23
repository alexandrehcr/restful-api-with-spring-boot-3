-- DATABASE
CREATE DATABASE IF NOT EXISTS cars_api;
USE cars_api;

-- TABLES
CREATE TABLE cars (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  category varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE roles (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  login varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_roles (
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  KEY FKh8ciramu9cc9q3qcqiv4ue8a6 (role_id),
  KEY FKhfh9dx7w3ubf1co1vdev94g3f (user_id),
  CONSTRAINT FKh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT FKhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES users (id)
);
