--liquibase formatted sql

--changeset SiarhKul:1
CREATE TABLE IF NOT EXISTS attachment
(
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    type VARCHAR(255),
    size BIGINT NOT NULL,
    uploaded_timestamp TIMESTAMP NOT NULL
);

