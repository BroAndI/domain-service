CREATE TABLE IF NOT EXISTS entities.rooms (
      id SERIAL PRIMARY KEY
    , name VARCHAR(128) not null
    , description VARCHAR(4000)
    , people INT
	, hotel_id INT REFERENCES entities.hotels(id)
);