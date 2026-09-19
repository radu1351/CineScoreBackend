CREATE TABLE movie (
    id BIGINT GENERATED  BY DEFAULT  AS IDENTITY PRIMARY KEY ,
    title VARCHAR(50),
    release_date DATE,
    duration_minutes INTEGER
);
