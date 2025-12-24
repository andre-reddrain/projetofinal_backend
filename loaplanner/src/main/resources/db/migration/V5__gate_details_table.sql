CREATE TABLE gate_details
(
    id             BINARY(16) NOT NULL,
    entry_lvl      INT NULL,
    extraloot_cost INT NULL,
    gate_id        BINARY(16) NULL,
    difficulty_id  BINARY(16) NULL,
    CONSTRAINT pk_gate_details PRIMARY KEY (id)
);

ALTER TABLE gate_details
    ADD CONSTRAINT FK_GATE_DETAILS_ON_DIFFICULTY FOREIGN KEY (difficulty_id) REFERENCES difficulties (id);

ALTER TABLE gate_details
    ADD CONSTRAINT FK_GATE_DETAILS_ON_GATE FOREIGN KEY (gate_id) REFERENCES gates (id);