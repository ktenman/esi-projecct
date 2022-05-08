--liquibase formatted sql

--changeset Ziya:0
CREATE SEQUENCE IF NOT EXISTS seq_customer;

CREATE TABLE IF NOT EXISTS customer
(
    id           BIGINT    NOT NULL
        CONSTRAINT customer_pkey
            PRIMARY KEY,
    id_code      VARCHAR
        CONSTRAINT customer_id_code
            UNIQUE         NOT NULL,
    fine_amount  DECIMAL(10, 5) DEFAULT 0,
    user_id      BIGINT NOT NULL
        CONSTRAINT fk_user
            REFERENCES "user",
    created_at   TIMESTAMP NOT NULL,
    created_by   VARCHAR,
    modified_at  TIMESTAMP,
    modified_by  VARCHAR
);

ALTER SEQUENCE IF EXISTS seq_customer
    OWNED BY customer.id;
