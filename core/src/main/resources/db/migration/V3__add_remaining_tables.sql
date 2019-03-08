CREATE TABLE rental (
  id          BIGSERIAL NOT NULL PRIMARY KEY,
  customer_id BIGINT    NOT NULL REFERENCES customer (id),
  start_date  DATE      NOT NULL
);

CREATE TABLE rental_return (
  rental_id   BIGINT NOT NULL REFERENCES rental (id),
  movie_id    TEXT NOT NULL REFERENCES movie (id),
  return_date DATE   NOT NULL,
  UNIQUE (rental_id, movie_id)
);

CREATE TABLE rental_entry (
  id        BIGSERIAL NOT NULL PRIMARY KEY,
  rental_id BIGINT    NOT NULL REFERENCES rental (id),
  movie_id  TEXT    NOT NULL REFERENCES movie (id),
  days      INT       NOT NULL,
  UNIQUE (rental_id, movie_id),
  CHECK ( DAYS > 0)
);

CREATE TABLE bonus_points_history (
  id          BIGSERIAL NOT NULL PRIMARY KEY,
  customer_id BIGINT    NOT NULL REFERENCES customer (id),
  rental_id   BIGINT REFERENCES rental (id),
  amount      INTEGER   NOT NULL,
  CHECK (amount != 0),
  UNIQUE (rental_id)
)