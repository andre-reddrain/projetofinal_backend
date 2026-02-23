CREATE TABLE character_activity_progress
(
    id            BINARY(16) NOT NULL,
    entry_counter INT        NOT NULL,
    activity_id   BINARY(16) NOT NULL,
    character_id  BINARY(16) NULL,
    user_id       BINARY(16) NULL,
    CONSTRAINT pk_character_activity_progress PRIMARY KEY (id)
);

ALTER TABLE character_activity_progress
    ADD CONSTRAINT FK_CHARACTER_ACTIVITY_PROGRESS_ON_ACTIVITY FOREIGN KEY (activity_id) REFERENCES activities (id);

ALTER TABLE character_activity_progress
    ADD CONSTRAINT FK_CHARACTER_ACTIVITY_PROGRESS_ON_CHARACTER FOREIGN KEY (character_id) REFERENCES characters (id);

ALTER TABLE character_activity_progress
    ADD CONSTRAINT FK_CHARACTER_ACTIVITY_PROGRESS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);