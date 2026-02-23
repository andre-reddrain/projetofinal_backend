CREATE TABLE rewards
(
    id              BINARY(16) NOT NULL,
    ammount         INT        NOT NULL,
    is_extra_reward BIT(1)     NOT NULL,
    gate_details_id BINARY(16) NOT NULL,
    type_rewards_id BINARY(16) NOT NULL,
    CONSTRAINT pk_rewards PRIMARY KEY (id)
);

ALTER TABLE rewards
    ADD CONSTRAINT FK_REWARDS_ON_GATE_DETAILS FOREIGN KEY (gate_details_id) REFERENCES gate_details (id);

ALTER TABLE rewards
    ADD CONSTRAINT FK_REWARDS_ON_TYPE_REWARDS FOREIGN KEY (type_rewards_id) REFERENCES type_rewards (id);