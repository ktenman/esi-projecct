--liquibase formatted sql

--changeset Konstantin:5
CREATE SEQUENCE IF NOT EXISTS seq_review;

CREATE TABLE IF NOT EXISTS review
(
    id          BIGINT    NOT NULL
        CONSTRAINT review_pkey
            PRIMARY KEY,
    book_id     BIGINT    NOT NULL
        CONSTRAINT fk_book_renting_request_review
            REFERENCES book,
    score       INTEGER   NOT NULL,
    comment     VARCHAR(1000),
    created_at  TIMESTAMP NOT NULL,
    created_by  BIGINT,
    modified_at TIMESTAMP,
    modified_by BIGINT
);

ALTER SEQUENCE IF EXISTS seq_review
    OWNED BY review.id;
