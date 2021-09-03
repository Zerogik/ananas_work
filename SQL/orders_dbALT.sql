CREATE SCHEMA studio;
USE studio;

CREATE TABLE role
(
    id   INT PRIMARY KEY NOT NULL,
    name VARCHAR(20)
);

CREATE TABLE salary_type
(
    id   INT PRIMARY KEY NOT NULL,
    name VARCHAR(20)
);

CREATE TABLE staff
(
    id        INT PRIMARY KEY NOT NULL,
    name      VARCHAR(50)     NOT NULL,
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
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    contacts VARCHAR(30) NOT NULL,
    email    VARCHAR(50),
    note     VARCHAR(250),
    source_id INT,
CONSTRAINT fk_source FOREIGN KEY (source_id) REFERENCES source (id)
);
CREATE TABLE projects
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    completed  BOOLEAN  NOT NULL,
    client_id INT NOT NULL,
    CONSTRAINT fk_project_client FOREIGN KEY (client_id) REFERENCES clients (id)
);
CREATE TABLE price
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    cost INT          NOT NULL
);

CREATE TABLE sessions
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    client_id  INT      NOT NULL,
    staff_id   INT      NOT NULL,
    price_id   INT      NOT NULL,
    project_id INT      NOT NULL,
    note       VARCHAR(255),
    start_time DATETIME NOT NULL,
    duration   INT      NOT NULL,
    paid       BOOLEAN  NOT NULL,
    CONSTRAINT fk_staff FOREIGN KEY (staff_id) REFERENCES staff (id),
    CONSTRAINT fk_cl FOREIGN KEY (client_id) REFERENCES clients (id),
    CONSTRAINT fk_price FOREIGN KEY (price_id) REFERENCES price (id),
    CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects (id)
);

CREATE TABLE checks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paydate DATETIME DEFAULT CURRENT_TIMESTAMP(),
    project_id INT NOT NULL,
    summ INT
)
CREATE TABLE source
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR (50)
);
