ALTER TABLE rewards
    ADD amount INT NULL;

UPDATE rewards
    SET amount = ammount;

ALTER TABLE rewards
    MODIFY COLUMN amount INT NOT NULL;

ALTER TABLE rewards
    DROP COLUMN ammount;