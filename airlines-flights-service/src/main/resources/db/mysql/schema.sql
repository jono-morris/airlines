
DROP DATABASE airlines;
CREATE DATABASE IF NOT EXISTS airlines;
--GRANT ALL PRIVILEGES ON airlines.* TO air@localhost IDENTIFIED BY 'air';

USE airlines;

CREATE TABLE IF NOT EXISTS airport (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(3),
  name VARCHAR(80),
  INDEX(code)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS airline (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(3),
  name VARCHAR(80),
  INDEX(code)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS route (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  flight_number VARCHAR(30),
  departure_time DATE,
  airline_id INT(4) UNSIGNED NOT NULL,
  origin_id INT(4) UNSIGNED NOT NULL,
  destination_id INT(4) UNSIGNED NOT NULL,
  INDEX(flight_number),
  FOREIGN KEY (airline_id) REFERENCES airline(id),
  FOREIGN KEY (origin_id) REFERENCES airport(id),
  FOREIGN KEY (destination_id) REFERENCES airport(id)
) engine=InnoDB;
