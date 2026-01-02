CREATE TABLE characters
(
    id                    BINARY(16)   NOT NULL,
    name                  VARCHAR(255) NULL,
    `description`         VARCHAR(255) NULL,
    ilvl                  DOUBLE       NULL,
    chaos_rest_counter    INT          NULL,
    guardian_rest_counter INT          NULL,
    user_id               BINARY(16)   NULL,
    class_id              BINARY(16)   NULL,
    CONSTRAINT pk_characters PRIMARY KEY (id)
);

ALTER TABLE characters
    ADD CONSTRAINT FK_CHARACTERS_ON_CLASS FOREIGN KEY (class_id) REFERENCES character_classes (id);

ALTER TABLE characters
    ADD CONSTRAINT FK_CHARACTERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);