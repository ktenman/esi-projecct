--liquibase formatted sql

--changeset Ziya:0
CREATE SEQUENCE IF NOT EXISTS seq_customer;

CREATE TABLE IF NOT EXISTS customer
(
    id           BIGINT    NOT NULL
        CONSTRAINT customer_pkey
            PRIMARY KEY,
    name         VARCHAR,
    address      VARCHAR,
    email        VARCHAR
        CONSTRAINT customer_email
            UNIQUE         NOT NULL,
    phone_number VARCHAR,
    id_code      VARCHAR
        CONSTRAINT customer_id_code
            UNIQUE         NOT NULL,
    fine_amount  DECIMAL(10, 5) DEFAULT 0,
    created_at   TIMESTAMP NOT NULL,
    created_by   BIGINT,
    modified_at  TIMESTAMP,
    modified_by  BIGINT
);

ALTER SEQUENCE IF EXISTS seq_customer
    OWNED BY customer.id;
