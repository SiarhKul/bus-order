--liquibase formatted sql

--changeset skulazhanka:1

INSERT INTO Station (id, city_id,station)
VALUES (11, 5, 'Field'),
       (12, 5, 'Forest');



