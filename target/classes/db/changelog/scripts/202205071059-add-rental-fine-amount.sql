--liquibase formatted sql

--changeset Konstantin:7
ALTER TABLE book_renting_request
    ADD COLUMN fine_amount DECIMAL(10, 5) DEFAULT 0;
