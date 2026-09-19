--liquibase formatted sql

--changeset radu:002-add-description-to-movie
ALTER TABLE movie DROP COLUMN description;
ALTER TABLE movie ADD COLUMN description VARCHAR(500);
