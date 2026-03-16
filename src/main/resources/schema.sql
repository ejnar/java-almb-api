CREATE TABLE companies
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    cvr          VARCHAR(20),
    phone_number VARCHAR(20),
    street       VARCHAR(255),
    city         VARCHAR(255),
    postal_code  VARCHAR(20),
    country      VARCHAR(100),
    revenue DOUBLE,
    expenses DOUBLE,
    net_profit DOUBLE
);