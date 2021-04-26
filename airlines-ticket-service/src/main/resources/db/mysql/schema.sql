
--DROP DATABASE ticket;
CREATE DATABASE IF NOT EXISTS ticket;
GRANT ALL PRIVILEGES ON ticket.* TO ticket@localhost IDENTIFIED BY 'ticket';

USE ticket;

CREATE TABLE IF NOT EXISTS passenger (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(10),
  surname VARCHAR(30),
  initial VARCHAR(1),
  INDEX(surname)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS ticket (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  currency VARCHAR(3),
  fare DECIMAL(10,2),
  date_of_issue TIME,
  passenger_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (passenger_id) references passenger(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS boarding_pass (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  flight_id INT(4) NOT NULL,
  status VARCHAR(30) NOT NULL,
  seat_class VARCHAR(30) NOT NULL,
  INDEX (flight_id)
) engine=InnoDB;