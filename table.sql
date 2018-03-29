CREATE TABLE crud_example.car
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    model VARCHAR(33) NOT NULL,
    max_speed INT NOT NULL,
    consumption FLOAT NOT NULL,
    volume_tank INT NOT NULL
);