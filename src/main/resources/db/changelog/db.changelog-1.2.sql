--liquibase formatted sql

--changeset skulazhanka:1
insert into client (name , surname, mobile_phone,e_mail ) values
    ('Jon','Doe', 45564, 'JonDoe@gmail.com');

