CREATE TABLE character_gate_progress
(
    id              BINARY(16) NOT NULL,
    is_completed    BIT(1)     NULL,
    buy_extra_loot  BIT(1)     NULL,
    character_id    BINARY(16) NOT NULL,
    gate_details_id BINARY(16) NOT NULL,
    CONSTRAINT pk_character_gate_progress PRIMARY KEY (id)
);

ALTER TABLE character_gate_progress
    ADD CONSTRAINT FK_CHARACTER_GATE_PROGRESS_ON_CHARACTER FOREIGN KEY (character_id) REFERENCES characters (id);

ALTER TABLE character_gate_progress
    ADD CONSTRAINT FK_CHARACTER_GATE_PROGRESS_ON_GATE_DETAILS FOREIGN KEY (gate_details_id) REFERENCES gate_details (id);