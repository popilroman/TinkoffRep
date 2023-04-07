--liquibase formatted sql

--changeset me:create-chat-table
CREATE TABLE Чаты (
  id INT NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

--changeset me:create-link-table
CREATE TABLE Ссылки (
  id INT NOT NULL PRIMARY KEY,
  url VARCHAR(255) NOT NULL,
  date_added TIMESTAMP NOT NULL,
  id_chat INT NOT NULL,
  CONSTRAINT fk_chat FOREIGN KEY (id_chat) REFERENCES Чаты(id)
);