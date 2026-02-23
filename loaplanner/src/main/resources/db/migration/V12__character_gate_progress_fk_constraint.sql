ALTER TABLE character_gate_progress
    ADD CONSTRAINT uc_623d7d1efcc2e133900d791c7 UNIQUE (character_id, gate_details_id);