--liquibase formatted sql

--changeset Ziya:0
CREATE SEQUENCE IF NOT EXISTS seq_user;

CREATE TABLE IF NOT EXISTS "user"
(
    id                  BIGINT NOT NULL
        PRIMARY KEY,
    created_at          TIMESTAMP NOT NULL,
    created_by          VARCHAR,
    modified_at         TIMESTAMP,
    modified_by         VARCHAR,
    username            VARCHAR
        CONSTRAINT uk_user_username
            UNIQUE,
    first_name          VARCHAR,
    last_name           VARCHAR,
    email               VARCHAR
        CONSTRAINT user_email
            UNIQUE      NOT NULL,
    password            VARCHAR,
    address             VARCHAR,
    type                VARCHAR,
    phone_number        VARCHAR,
    activated           boolean default false
);

ALTER SEQUENCE IF EXISTS seq_user
    OWNED BY "user".id;

CREATE SEQUENCE IF NOT EXISTS seq_authority;

CREATE TABLE IF NOT EXISTS authority
(
    id                  BIGINT NOT NULL
        PRIMARY KEY,
    role                VARCHAR
);

ALTER SEQUENCE IF EXISTS seq_user
    OWNED BY authority.id;

CREATE TABLE IF NOT EXISTS user_authority
(
    user_id      BIGINT NOT NULL
        CONSTRAINT fk_user
            REFERENCES "user",
    authority_id BIGINT NOT NULL
        CONSTRAINT fk_authority
            REFERENCES authority,
    PRIMARY KEY (user_id, authority_id)
);