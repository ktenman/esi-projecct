--liquibase formatted sql

--changeset Ziya:0
insert into public.authority (id, role)
values  (nextval('seq_authority'), 'LIBRARIAN'),
        (nextval('seq_authority'), 'CUSTOMER');