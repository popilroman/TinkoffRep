--liquibase formatted sql

SET search_path TO public;

--changeset me:create-chat-table
CREATE TABLE public.Chats (
  id INT NOT NULL PRIMARY KEY,
  name_chat VARCHAR(255) NOT NULL
);

--changeset me:create-link-table
CREATE TABLE Links (
  id INT NOT NULL PRIMARY KEY,
  url VARCHAR(255) NOT NULL,
  date_added TIMESTAMP NOT NULL,
  id_chat INT NOT NULL,
  CONSTRAINT fk_chat FOREIGN KEY (id_chat) REFERENCES public.Chats(id)
);