CREATE TABLE activities
(
    id          BINARY(16)   NOT NULL,
    name        VARCHAR(255) NULL,
    type        VARCHAR(255) NULL,
    reset_type  VARCHAR(255) NULL,
    max_entries INT          NULL,
    CONSTRAINT pk_activities PRIMARY KEY (id)
);