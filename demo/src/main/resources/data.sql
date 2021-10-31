DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  new_message VARCHAR(250) NOT NULL
  
);

INSERT INTO messages (new_message) VALUES
  ('test message');
  