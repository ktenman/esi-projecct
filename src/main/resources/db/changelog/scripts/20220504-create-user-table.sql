--liquibase formatted sql

--changeset Ziya:0

CREATE TABLE IF NOT EXISTS "user"
(
    id                  uuid      not null
        primary key,
    created_at          timestamp not null,
    created_by          uuid,
    modified_at         timestamp,
    modified_by         uuid,
    username            varchar
        constraint uk_user_username
            unique,
    first_name          varchar,
    last_name           varchar,
    email               varchar,
    phone_number        varchar
);