--liquibase formatted sql

--changeset skulazhanka:1
alter table attachment
    add status VARCHAR