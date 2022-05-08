--liquibase formatted sql

--changeset Konstantin:8
ALTER TABLE book ALTER COLUMN category TYPE VARCHAR(255);
