CREATE SCHEMA if NOT EXISTS reference_data;

CREATE TABLE IF NOT EXISTS reference_data.offensive_personnel (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  display_name VARCHAR(7) UNIQUE NOT NULL,
  description VARCHAR(11) NOT NULL,
  option_number INTEGER UNIQUE NOT NULL,
  creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  last_updated_date TIMESTAMP
);
