--changeset skulazhanka:1
ALTER TABLE Route DROP COLUMN route;

--changeset skulazhanka:2
alter table Route
    ADD COLUMN departure_city_id INT REFERENCES city(id),
    ADD COLUMN destination_city_id INT REFERENCES city(id);

