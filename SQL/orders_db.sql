CREATE DATABASE orders;
USE ORDERS;

CREATE TABLE role
(
    id      INT PRIMARY KEY NOT NULL,
    rl_name VARCHAR(20)
);
CREATE TABLE salary_type
(
    id      INT PRIMARY KEY NOT NULL,
    sl_name VARCHAR(20)
);
CREATE TABLE staff
(
    id        INT PRIMARY KEY NOT NULL,
    st_name   VARCHAR(50)     NOT NULL,
    username  VARCHAR(20)     NOT NULL,
    password  VARCHAR(255)    NOT NULL,
    contact   VARCHAR(30)     NOT NULL,
    email     VARCHAR(100)    NOT NULL,
    role_id   INT             NOT NULL,
    activity  BOOLEAN,
    salary_id INT             NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY (role_id)
        REFERENCES role (id),
    CONSTRAINT fk_salary FOREIGN KEY (salary_id)
        REFERENCES salary_type (id)
);
CREATE TABLE clients
(
    cl_id INT PRIMARY KEY AUTO_INCREMENT,
    cl_name VARCHAR (50) NOT NULL,
    contacts VARCHAR (30) NOT NULL,
    email VARCHAR (50),
    note VARCHAR (250)
);
CREATE TABLE zakaz
(
    or_id INT PRIMARY KEY AUTO_INCREMENT,
    client_id INT NOT NULL,
    pr_name VARCHAR (250),
    note VARCHAR (250),
    staff_id INT,
    completed BOOLEAN,
    paid BOOLEAN,
    CONSTRAINT fk_staff FOREIGN KEY (staff_id) REFERENCES staff (id),
    CONSTRAINT fk_cl FOREIGN KEY (client_id) REFERENCES clients (cl_id)
);
CREATE TABLE sessions
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT NOT NULL,
    zakaz_id INT NOT NULL,
    start_time DATETIME NOT NULL,
    hours INT NOT NULL,
    CONSTRAINT fk_session_staff FOREIGN KEY (staff_id) REFERENCES staff (id),
    CONSTRAINT fk_zakaz FOREIGN KEY (zakaz_id) REFERENCES zakaz (or_id)
);
CREATE TABLE price
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR (30) NOT NULL,
    cst INT NOT NULL
);
ALTER TABLE zakaz
    ADD COLUMN name_price INT
AFTER or_id;

CREATE TABLE cost
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name_price INT,
    hours INT,
    CONSTRAINT fk_cstmix FOREIGN KEY (name_price)
        REFERENCES zakaz (name_price)
);


