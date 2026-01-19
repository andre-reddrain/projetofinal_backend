ALTER TABLE gate_details
    DROP FOREIGN KEY FK_GATE_DETAILS_ON_DIFFICULTY;

ALTER TABLE gate_details
    ADD difficulty VARCHAR(255) NULL;

DROP TABLE difficulties;

ALTER TABLE character_activity_progress
    DROP COLUMN character_char_id;

ALTER TABLE character_activity_progress
    DROP COLUMN roster_user_id;

ALTER TABLE gate_details
    DROP COLUMN difficulty_id;