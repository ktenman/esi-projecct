--liquibase formatted sql

--changeset Ziya:8
insert into customer (id, id_code, fine_amount, user_id, created_at, created_by, modified_at, modified_by)
values  (nextval('seq_customer'), 'ABC123', 1231.00000, (select id from "user" where username = 'siim'), NOW(), 'ziya', NOW(), 'ziya'),
        (nextval('seq_customer'), 'QWE345', 4636.00000, (select id from "user" where username = 'tofig'), NOW(), 'ziya', NOW(), 'ziya');