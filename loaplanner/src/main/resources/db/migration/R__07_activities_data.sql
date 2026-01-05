INSERT INTO activities (id, name, type, reset_type, max_entries, min_ilvl) VALUES
(UUID_TO_BIN('1781f6af-e0eb-11f0-a6e8-0a0027000013'), 'Chaos Dungeon', 'Character', 'Daily', 1, 250),
(UUID_TO_BIN('17820652-e0eb-11f0-a6e8-0a0027000013'), 'Guardian Raid', 'Character', 'Daily', 1, 500),
(UUID_TO_BIN('17820a79-e0eb-11f0-a6e8-0a0027000013'), 'Daily Una\'s', 'Character', 'Daily', 3, 0),
(UUID_TO_BIN('17820b70-e0eb-11f0-a6e8-0a0027000013'), 'Weekly Una\'s', 'Character', 'Weekly', 3, 0),
(UUID_TO_BIN('17820c2c-e0eb-11f0-a6e8-0a0027000013'), 'Chaos Gate', 'Roster', 'Daily', 1, 1415),
(UUID_TO_BIN('17820cd3-e0eb-11f0-a6e8-0a0027000013'), 'Adventure Island', 'Roster', 'Daily', 1, 250),
(UUID_TO_BIN('17820d7b-e0eb-11f0-a6e8-0a0027000013'), 'Field Boss', 'Roster', 'Daily', 1, 1640),
(UUID_TO_BIN('17820e14-e0eb-11f0-a6e8-0a0027000013'), 'Paradise', 'Character', 'Weekly', 5, 1580)
ON DUPLICATE KEY UPDATE
    name = IF(name <> VALUES(name), VALUES(name), name),
    type = IF(type <> VALUES(type), VALUES(type), type),
    reset_type = IF(reset_type <> VALUES(reset_type), VALUES(reset_type), reset_type),
    max_entries = IF(max_entries <> VALUES(max_entries), VALUES(max_entries), max_entries),
    min_ilvl = IF(min_ilvl IS NULL OR min_ilvl <> VALUES(min_ilvl), VALUES(min_ilvl), min_ilvl);