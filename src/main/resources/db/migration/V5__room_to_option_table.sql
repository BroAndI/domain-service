CREATE TABLE IF NOT EXISTS entities.room_to_option (
      room_id INT REFERENCES rooms(id)
    , option_id INT REFERENCES "options"(id)
);