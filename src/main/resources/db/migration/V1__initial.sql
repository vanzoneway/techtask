CREATE TYPE user_status AS ENUM ('ACTIVE', 'INACTIVE');

CREATE TABLE users
(
    id          SERIAL PRIMARY KEY,
    email       VARCHAR(255) UNIQUE NOT NULL,
    user_status user_status         NOT NULL
);

CREATE TYPE order_status AS ENUM ('CREATED', 'PAID', 'FAILED', 'DELIVERED');

CREATE TABLE orders
(
    id           SERIAL PRIMARY KEY,
    product_name VARCHAR(255)   NOT NULL,
    price        DECIMAL(10, 2) NOT NULL,
    quantity     INT            NOT NULL,
    user_id      INT            NOT NULL,
    created_at   TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    order_status order_status   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO users (id, email, user_status)
VALUES (1, 'user1@email.com', 'ACTIVE'),
       (2, 'user2@email.com', 'ACTIVE'),
       (3, 'user3@email.com', 'INACTIVE'),
       (4, 'user4@email.com', 'ACTIVE'),
       (5, 'user5@email.com', 'ACTIVE'),
       (6, 'user6@email.com', 'INACTIVE'),
       (7, 'user7@email.com', 'ACTIVE');

INSERT INTO orders (id, product_name, price, quantity, user_id, created_at, order_status)
VALUES (1, 'Apple', 10, 130, 1, '2003-07-28 12:00:00', 'CREATED'),
       (2, 'Lemon', 30, 2, 1, '2004-05-31 12:00:00', 'DELIVERED'),
       (3, 'Cucumber', 5, 10, 1, '2010-06-01 12:00:00', 'PAID'),
       (4, 'Cabbage', 7, 2, 2, '2023-08-08 12:00:00', 'DELIVERED'),
       (5, 'Onion', 8, 6, 2, '2019-01-01 12:00:00', 'FAILED'),
       (6, 'Carrot', 9, 5, 2, '2020-09-10 12:00:00', 'DELIVERED'),
       (7, 'Mango', 40, 2, 3, '2010-11-13 12:00:00', 'FAILED'),
       (8, 'Orange', 45, 5, 4, '2003-03-03 12:00:00', 'DELIVERED'),
       (9, 'Watermelon', 100, 1, 4, '2024-03-08 12:00:00', 'DELIVERED'),
       (10, 'Garlic', 8, 12, 4, '2019-05-14 12:00:00', 'DELIVERED'),
       (11, 'Potato', 3, 100, 7, '2010-01-01 12:00:00', 'PAID'),
       (12, 'Carrot', 9, 15, 7, '2006-09-01 12:00:00', 'FAILED'),
       (13, 'Onion', 8, 15, 7, '2003-05-30 12:00:00', 'DELIVERED'),
       (14, 'Pumpkin', 50, 1, 7, '2021-06-11 12:00:00', 'PAID'),
       (15, 'Watermelon', 100, 12, 7, '2003-12-21 12:00:00', 'DELIVERED');

