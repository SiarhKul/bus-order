--liquibase formatted sql

--changeset skulazhanka:1
alter table booking alter column date type date using date::date;



