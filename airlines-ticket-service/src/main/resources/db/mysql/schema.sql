
--DROP DATABASE airlines;
CREATE DATABASE IF NOT EXISTS ticket;
GRANT ALL PRIVILEGES ON ticket.* TO ticket@localhost IDENTIFIED BY 'ticket';

USE ticket;

CREATE TABLE IF NOT EXISTS ticket (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(10),
  surname VARCHAR(30),
  initial VARCHAR(1)
  INDEX(surname)
) engine=InnoDB;
