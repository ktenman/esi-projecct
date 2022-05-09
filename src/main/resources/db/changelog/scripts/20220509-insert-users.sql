--liquibase formatted sql

--changeset Ziya:0

insert into "user" (id, created_at, created_by, modified_at, modified_by, username, first_name, last_name, email, password, address, type, phone_number, activated)
values  (nextval('seq_authority'), NOW(), 'ziya', NOW(), 'ziya', 'ziya', 'Ziya', 'Mammadov', 'ziya@ut.ee', '$2a$10$58O3LPF50EG8JtxmQ4Yt8OMbTds7L7u5KsaoOPagWeuO5tMEA3uO6', null, 'LIBRARIAN', null, true),
        (nextval('seq_authority'), NOW(), 'ziya', NOW(), 'ziya', 'konstantin', 'Konstantin', 'Tenman', 'konstantin@ut.ee', '$2a$10$58O3LPF50EG8JtxmQ4Yt8OMbTds7L7u5KsaoOPagWeuO5tMEA3uO6', null, 'LIBRARIAN', null, true),
        (nextval('seq_authority'), NOW(), 'ziya', NOW(), 'ziya', 'siim', 'Siim-Morten', 'Ojasalu', 'siim@ut.ee', '$2a$10$58O3LPF50EG8JtxmQ4Yt8OMbTds7L7u5KsaoOPagWeuO5tMEA3uO6', null, 'CUSTOMER', null, true),
        (nextval('seq_authority'), NOW(), 'ziya', NOW(), 'ziya', 'tofig', 'Tofig', 'Bakhshiyev', 'tofig@ut.ee', '$2a$10$58O3LPF50EG8JtxmQ4Yt8OMbTds7L7u5KsaoOPagWeuO5tMEA3uO6', null, 'CUSTOMER', null, true);

insert into user_authority (user_id, authority_id)
values  ((select id from "user" where username = 'ziya'), (select id from authority where role = 'LIBRARIAN')),
        ((select id from "user" where username = 'konstantin'), (select id from authority where role = 'LIBRARIAN')),
        ((select id from "user" where username = 'siim'), (select id from authority where role = 'CUSTOMER')),
        ((select id from "user" where username = 'tofig'), (select id from authority where role = 'CUSTOMER'));