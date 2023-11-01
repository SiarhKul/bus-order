--liquibase formatted sql

--changeset skulazhanka:1
alter table client
    add password varchar;



