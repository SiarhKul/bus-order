--liquibase formatted sql

--changeset skulazhanka:1
alter table schedule
    add ticket_price int;

--changeset skulazhanka:2
UPDATE schedule
SET ticket_price =1
WHERE id=1

--changeset skulazhanka:3
UPDATE schedule
SET ticket_price =10
WHERE id=2

--changeset skulazhanka:4
UPDATE schedule
SET ticket_price =100
WHERE id=3

--changeset skulazhanka:5
UPDATE schedule
SET ticket_price =1000
WHERE id=4

--changeset skulazhanka:6
UPDATE schedule
SET ticket_price =10000
WHERE id=5

--changeset skulazhanka:7
UPDATE schedule
SET ticket_price =1000000
WHERE id = 6;

--changeset skulazhanka:8
UPDATE schedule
SET ticket_price =10000000
WHERE id=7