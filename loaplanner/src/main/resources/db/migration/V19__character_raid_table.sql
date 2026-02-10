CREATE TABLE character_raid
(
    id           BINARY(16) NOT NULL,
    character_id BINARY(16) NOT NULL,
    raid_id      BINARY(16) NOT NULL,
    is_tracked   BIT(1)     NOT NULL,
    CONSTRAINT pk_character_raid PRIMARY KEY (id)
);

ALTER TABLE character_raid
    ADD CONSTRAINT uc_32030187d0f279c968d66706a UNIQUE (character_id, raid_id);

ALTER TABLE character_raid
    ADD CONSTRAINT FK_CHARACTER_RAID_ON_CHARACTER FOREIGN KEY (character_id) REFERENCES characters (id);

ALTER TABLE character_raid
    ADD CONSTRAINT FK_CHARACTER_RAID_ON_RAID FOREIGN KEY (raid_id) REFERENCES raids (id);