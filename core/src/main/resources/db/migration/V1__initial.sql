CREATE TABLE movie (
  id    TEXT NOT NULL PRIMARY KEY,
  title TEXT      NOT NULL,
  type  TEXT      NOT NULL,
  year  INTEGER   NOT NULL,
  UNIQUE (title, year),
  CHECK ( YEAR >= 1878) -- First movie ever: "The Horse In Motion", created by Eadweard Muybridge in 1878
);

CREATE TABLE customer (
  id    BIGSERIAL PRIMARY KEY,
  name  TEXT NOT NULL,
  email TEXT NOT NULL UNIQUE
);
