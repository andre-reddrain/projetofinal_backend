CREATE TABLE character_classes
(
    id      BINARY(16)   NOT NULL,
    type    VARCHAR(255) NULL,
    subtype VARCHAR(255) NULL,
    icon    VARCHAR(255) NULL,
    CONSTRAINT pk_character_classes PRIMARY KEY (id)
);