DROP TABLE route IF EXISTS;
DROP TABLE airline IF EXISTS;
DROP TABLE airport IF EXISTS;
DROP TABLE flight IF EXISTS;

CREATE TABLE airport (
  id   INTEGER IDENTITY PRIMARY KEY,
  code VARCHAR(3),
  name VARCHAR(80)
);
CREATE INDEX airport_code ON airport (code);

CREATE TABLE airline (
  id   INTEGER IDENTITY PRIMARY KEY,
  code VARCHAR(3),
  name VARCHAR(80)
);
CREATE INDEX airline_code ON airline (code);

CREATE TABLE route (
  id              INTEGER IDENTITY PRIMARY KEY,
  flight_number   VARCHAR(30),
  departure_time  DATE,
  airline_id      INTEGER NOT NULL,
  origin_id       INTEGER NOT NULL,
  destination_id  INTEGER NOT NULL
);
CREATE INDEX route_flight_number ON route (flight_number);

ALTER TABLE route ADD CONSTRAINT fk_route_airline FOREIGN KEY (airline_id) REFERENCES airline(id);
ALTER TABLE route ADD CONSTRAINT fk_route_origin FOREIGN KEY (origin_id) REFERENCES airport(id);
ALTER TABLE route ADD CONSTRAINT fk_route_destination FOREIGN KEY (destination_id) REFERENCES airport(id);
