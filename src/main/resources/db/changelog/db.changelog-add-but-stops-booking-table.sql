--liquibase formatted sql

--changeset skulazhanka:1
alter table booking
    add bus_stop_departure varchar;

--changeset skulazhanka:2
alter table booking
    add bus_stop_destination varchar;

