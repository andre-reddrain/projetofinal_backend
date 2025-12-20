CREATE TABLE type_rewards
(
    id         BINARY(16)   NOT NULL,
    name       VARCHAR(255) NULL,
    tier       INT NULL,
    class_type VARCHAR(255) NULL,
    grade      VARCHAR(255) NULL,
    icon       VARCHAR(255) NULL,
    CONSTRAINT pk_type_rewards PRIMARY KEY (id)
);