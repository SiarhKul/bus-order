--liquibase formatted sql

--changeset skulazhanka:1
insert into Route(route)
values ('Minsk-Homel'),
       ('Minsk-Vitebsk'),
       ('Homel-Brest'),
       ('Minsk-Grodno'),
       ('Vitebsk-Mogilev');


