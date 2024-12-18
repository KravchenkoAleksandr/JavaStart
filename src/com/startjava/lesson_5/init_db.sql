\c robots;

CREATE TABLE jaegers (
    PRIMARY KEY (id),
    id         SERIAL   NOT NULL,
    model_name TEXT     NOT NULL,
    mark       CHAR(6)  NOT NULL,
    height     INTEGER,
    weight     NUMERIC,
    status     TEXT     NOT NULL,
    origin     TEXT,
    launch     DATE     NOT NULL,
    kaiju_kill INTEGER  NOT NULL
);

\i populate.sql;

\i queries.sql;