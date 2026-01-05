CREATE TABLE activity_details
(
    id          BINARY(16)   NOT NULL,
    name        VARCHAR(255) NOT NULL,
    entry_lvl   INT          NOT NULL,
    activity_id BINARY(16)   NOT NULL,
    CONSTRAINT pk_activity_details PRIMARY KEY (id)
);

ALTER TABLE activity_details
    ADD CONSTRAINT FK_ACTIVITY_DETAILS_ON_ACTIVITY FOREIGN KEY (activity_id) REFERENCES activities (id);