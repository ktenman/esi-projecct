--liquibase formatted sql

--changeset Siim:1
CREATE SEQUENCE IF NOT EXISTS seq_librarian;

CREATE TABLE IF NOT EXISTS librarian
(
    id           BIGINT    NOT NULL
        CONSTRAINT librarian_pkey
            PRIMARY KEY,
    name         VARCHAR,
    address      VARCHAR,
    email        VARCHAR
        CONSTRAINT librarian_email
            UNIQUE,
    phone_number VARCHAR,
    created_at   TIMESTAMP NOT NULL,
    created_by   BIGINT,
    modified_at  TIMESTAMP,
    modified_by  BIGINT
);

ALTER SEQUENCE IF EXISTS seq_librarian
    OWNED BY librarian.id;
