CREATE TABLE gates
(
    id      BINARY(16)   NOT NULL,
    number  INT NULL,
    name    VARCHAR(255) NULL,
    raid_id BINARY(16)   NULL,
    CONSTRAINT pk_gates PRIMARY KEY (id)
);

CREATE TABLE raids
(
    id   BINARY(16)   NOT NULL,
    name VARCHAR(255) NULL,
    type VARCHAR(255) NULL,
    icon VARCHAR(255) NULL,
    CONSTRAINT pk_raids PRIMARY KEY (id)
);

ALTER TABLE gates
    ADD CONSTRAINT FK_GATES_ON_RAID FOREIGN KEY (raid_id) REFERENCES raids (id);