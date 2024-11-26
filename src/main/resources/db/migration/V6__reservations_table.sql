CREATE TABLE IF NOT EXISTS entities.reservations (
    room_id INT REFERENCES rooms(id)
  , taken_from date not null
  , taken_to date not null
);