CREATE TABLE IF NOT EXISTS entities.address (
  id SERIAL PRIMARY KEY
, country VARCHAR(128) not null
, city VARCHAR(128) not null
, street VARCHAR(128) not null
, house VARCHAR(24) not null
, apartment VARCHAR(12)
, zip VARCHAR(128)
);