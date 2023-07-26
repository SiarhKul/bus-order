--liquibase formatted sql

--changeset skulazhanka:1
CREATE TABLE IF NOT EXISTS City
(
    id INT primary key generated by default as identity,
    name    VARCHAR not null
);

--changeset skulazhanka:2
CREATE TABLE IF NOT EXISTS Route
(
    id INT primary key generated by default as identity,
    route    VARCHAR not null
);

--changeset skulazhanka:3
CREATE TABLE IF NOT EXISTS Client
(
    id INT primary key generated by default as identity,
    name VARCHAR not null,
    surname VARCHAR not null,
    mobile_phone INT not null,
    e_mail INT not null unique
);

--changeset skulazhanka:4
CREATE TABLE IF NOT EXISTS Booking (
    id INT primary key generated by default as identity,
    status VARCHAR,
    data TIMESTAMP,
    client_id int REFERENCES client(id)
)

/*--changeset skulazhanka:5
CREATE TABLE products (
                          product_no integer PRIMARY KEY,
                          name text,
                          price numeric
);
CREATE TABLE orders (
                        order_id integer PRIMARY KEY,
                        product_id integer REFERENCES products (product_no),
                        quantity integer
);*/