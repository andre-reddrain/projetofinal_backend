INSERT INTO difficulties (id, mode) VALUES
(UUID_TO_BIN('34314be0-df5b-11f0-a6e8-0a0027000013'), 'Solo'),
(UUID_TO_BIN('3431541e-df5b-11f0-a6e8-0a0027000013'), 'Normal'),
(UUID_TO_BIN('34315586-df5b-11f0-a6e8-0a0027000013'), 'Hard')
ON DUPLICATE KEY UPDATE
    mode = IF(mode <> VALUES(mode), VALUES(mode), mode);