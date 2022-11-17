CREATE TABLE columns
(
    id   SERIAL PRIMARY KEY NOT NULL,
    name TEXT               NOT NULL
);

CREATE TABLE tasks
(
    id             SERIAL,
    columns_id     SERIAL       NOT NULL REFERENCES columns (id) ON DELETE CASCADE,
    name           TEXT         NOT NULL,
    description    TEXT         NOT NULL,
    dateOfCreation varchar(256) NOT NULL
);
