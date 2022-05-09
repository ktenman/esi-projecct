--liquibase formatted sql

--changeset Konstantin:6
CREATE SEQUENCE IF NOT EXISTS seq_notification;

CREATE TABLE IF NOT EXISTS notification
(
    id          BIGINT    NOT NULL
        CONSTRAINT notification_pkey
            PRIMARY KEY,
    customer_id BIGINT    NOT NULL
        CONSTRAINT fk_customer_notification
            REFERENCES customer,
    renting_id  BIGINT    NOT NULL
        CONSTRAINT fk_renting_notification
            REFERENCES book_renting_request,
    message     VARCHAR(1000),
    created_at  TIMESTAMP NOT NULL,
    created_by  VARCHAR,
    modified_at TIMESTAMP,
    modified_by VARCHAR
);

ALTER SEQUENCE IF EXISTS seq_notification
    OWNED BY notification.id;
