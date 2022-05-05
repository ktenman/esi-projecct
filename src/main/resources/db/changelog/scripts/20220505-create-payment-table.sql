--liquibase formatted sql

--changeset Konstantin:2
CREATE SEQUENCE IF NOT EXISTS seq_payment;

CREATE TABLE IF NOT EXISTS payment
(
    id           BIGINT NOT NULL
        CONSTRAINT payment_pkey
            PRIMARY KEY,
    details            JSONB       NOT NULL,
    customer_id     bigint       not null
    constraint fk_payment_customer
    references customer
);

ALTER SEQUENCE IF EXISTS seq_payment
    OWNED BY payment.id;
