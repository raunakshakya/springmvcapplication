CREATE DATABASE SPRING_SECURITY_DB_PASSWORD_HASHING;

USE SPRING_SECURITY_DB_PASSWORD_HASHING;

CREATE TABLE users (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(60) NOT NULL,
  enabled  TINYINT     NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles (
  user_role_id INT(11)     NOT NULL AUTO_INCREMENT,
  username     VARCHAR(45) NOT NULL,
  role         VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role, username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users (username, password, enabled)
VALUES ('mkyong', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', TRUE);

INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_ADMIN');
