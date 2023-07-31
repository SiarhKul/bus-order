--changeset skulazhanka:1
ALTER TABLE Route DROP COLUMN route;

--changeset skulazhanka:2
alter table Route
    ADD COLUMN departure_city VARCHAR,
    ADD COLUMN destination_city VARCHAR;

