--liquibase formatted sql

--changeset Konstantin:2
CREATE SEQUENCE IF NOT EXISTS seq_payment;

CREATE TABLE IF NOT EXISTS payment
(
    id          BIGINT    NOT NULL
        CONSTRAINT payment_pkey
            PRIMARY KEY,
    details     JSONB     NOT NULL,
    customer_id BIGINT    NOT NULL
        CONSTRAINT fk_payment_customer
            REFERENCES customer,
    created_at  TIMESTAMP NOT NULL,
    created_by  VARCHAR,
    modified_at TIMESTAMP,
    modified_by VARCHAR
);

ALTER SEQUENCE IF EXISTS seq_payment
    OWNED BY payment.id;
