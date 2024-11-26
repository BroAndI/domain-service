CREATE TABLE IF NOT EXISTS entities.hotels (
      id SERIAL PRIMARY KEY
    , name VARCHAR(128) not null
    , description VARCHAR(4000)
    , address_id INT REFERENCES address(id)
);