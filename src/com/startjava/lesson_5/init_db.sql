\c robots;

DROP TABLE jaegers;

CREATE TABLE jaegers(
    id SERIAL PRIMARY KEY,
    model_name TEXT,
    mark CHAR(6),
    height INTEGER,
    weight DOUBLE PRECISION,
    status TEXT,
    origin TEXT,
    launch DATE,
    kaiju_kill INTEGER);

\i populate.sql;

\i queries.sql;