--liquibase formatted sql

--changeset Ziya:0
insert into public.authority (id, role)
values  (1, 'LIBRARIAN'),
        (2, 'CUSTOMER');