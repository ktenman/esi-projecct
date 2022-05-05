--liquibase formatted sql

--changeset Ziya:0
CREATE SEQUENCE IF NOT EXISTS seq_customer;

CREATE TABLE IF NOT EXISTS customer
(
    id           BIGINT NOT NULL
        CONSTRAINT customer_pkey
            PRIMARY KEY,
    name         VARCHAR,
    address      VARCHAR,
    email        VARCHAR
        CONSTRAINT customer_email
            UNIQUE,
    phone_number VARCHAR,
    id_code      VARCHAR,
    fine_amount  DECIMAL(10, 5)
);

ALTER SEQUENCE IF EXISTS seq_customer
    OWNED BY customer.id;
