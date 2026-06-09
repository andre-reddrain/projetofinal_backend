CREATE TABLE rewards
(
    id              BINARY(16) NOT NULL,
    amount          INT        NOT NULL,
    is_extra_reward BIT(1)     NOT NULL,
    gate_details_id BINARY(16) NOT NULL,
    type_rewards_id BINARY(16) NOT NULL,
    CONSTRAINT pk_rewards PRIMARY KEY (id)
);

CREATE TABLE type_rewards
(
    id         BINARY(16)   NOT NULL,
    name       VARCHAR(255) NULL,
    tier       INT          NULL,
    class_type VARCHAR(255) NULL,
    grade      VARCHAR(255) NULL,
    icon       VARCHAR(255) NULL,
    CONSTRAINT pk_type_rewards PRIMARY KEY (id)
);

ALTER TABLE rewards
    ADD CONSTRAINT FK_REWARDS_ON_TYPE_REWARDS FOREIGN KEY (type_rewards_id) REFERENCES type_rewards (id);