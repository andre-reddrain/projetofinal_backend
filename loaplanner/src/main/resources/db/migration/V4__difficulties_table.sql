CREATE TABLE difficulties
(
    id   BINARY(16)   NOT NULL,
    mode VARCHAR(255) NULL,
    CONSTRAINT pk_difficulties PRIMARY KEY (id)
);