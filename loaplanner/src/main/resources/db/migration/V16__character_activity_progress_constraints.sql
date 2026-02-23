-- Daily: character_id if user_id IS NULL
ALTER TABLE character_activity_progress
    ADD COLUMN character_char_id BINARY(16) AS (CASE WHEN user_id IS NULL THEN character_id ELSE NULL END) STORED;

CREATE UNIQUE INDEX uq_progress_character
    ON character_activity_progress (character_char_id, activity_id);

-- Weekly: user_id if character_id IS NULL
ALTER TABLE character_activity_progress
    ADD COLUMN roster_user_id BINARY(16) AS (CASE WHEN character_id IS NULL THEN user_id ELSE NULL END) STORED;

CREATE UNIQUE INDEX uq_progress_roster
    ON character_activity_progress (roster_user_id, activity_id);