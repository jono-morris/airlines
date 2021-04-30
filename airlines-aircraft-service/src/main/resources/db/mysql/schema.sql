
--DROP DATABASE aircraft;
CREATE DATABASE IF NOT EXISTS aircraft;
GRANT ALL PRIVILEGES ON aircraft.* TO ticket@localhost IDENTIFIED BY 'aircraft';

USE aircraft;

CREATE TABLE IF NOT EXISTS aircraft (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  free_seats INT(3) NOT NULL,
  flight_id INT(4) NOT NULL,
  registration_number VARCHAR(10),
  aircraft_type VARCHAR(40),
  description VARCHAR(50),
  INDEX(registration_number)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS seat (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  boarding_pass_id INT(4),
  number VARCHAR(5) NOT NULL,
  aircraft_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (aircraft_id) REFERENCES aircraft(id)
) engine=InnoDB;
