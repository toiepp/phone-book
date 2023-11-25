CREATE TABLE records
(
    id    serial PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    phone VARCHAR(20)  NOT NULL
);

INSERT INTO records (name, phone)
VALUES ('Jack', '750912769'),
       ('Michael', '7674859634');