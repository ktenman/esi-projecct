--liquibase formatted sql

--changeset Konstantin:4
CREATE SEQUENCE IF NOT EXISTS seq_book_renting_request;

CREATE TABLE IF NOT EXISTS book_renting_request
(
    id           BIGINT      NOT NULL
        CONSTRAINT book_renting_request_pkey
            PRIMARY KEY,
    customer_id  BIGINT      NOT NULL
        CONSTRAINT fk_book_renting_request_customer
            REFERENCES customer,
    book_id      BIGINT      NOT NULL
        CONSTRAINT fk_book_renting_request_book
            REFERENCES book,
    status       VARCHAR(30) NOT NULL,
    rented_at    TIMESTAMP,
    rented_until TIMESTAMP,
    created_at   TIMESTAMP   NOT NULL,
    created_by   VARCHAR,
    modified_at  TIMESTAMP,
    modified_by  VARCHAR
);

ALTER SEQUENCE IF EXISTS seq_book_renting_request
    OWNED BY book_renting_request.id;
