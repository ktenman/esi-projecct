--liquibase formatted sql

--changeset Konstantin:3
CREATE SEQUENCE IF NOT EXISTS seq_book;

CREATE TABLE IF NOT EXISTS book
(
    id           BIGINT      NOT NULL
        CONSTRAINT book_pkey
            PRIMARY KEY,
    author       VARCHAR,
    title        VARCHAR,
    release_date DATE DEFAULT CURRENT_DATE,
    status       VARCHAR(30) NOT NULL,
    language     VARCHAR(17) NOT NULL,
    category     VARCHAR(33) NOT NULL,
    created_at   TIMESTAMP   NOT NULL,
    created_by   BIGINT,
    modified_at  TIMESTAMP,
    modified_by  BIGINT
);

ALTER SEQUENCE IF EXISTS seq_book
    OWNED BY book.id;
