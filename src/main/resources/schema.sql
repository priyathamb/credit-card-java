DROP TABLE IF EXISTS CARD;

CREATE TABLE CARD (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  given_name VARCHAR(250) NOT NULL,
  card_number VARCHAR(250) NOT NULL,
  card_limit VARCHAR(250) NOT NULL
);