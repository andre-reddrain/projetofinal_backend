INSERT INTO activities (id, name, type, reset_type, max_entries, min_ilvl, icon) VALUES
(UUID_TO_BIN('1781f6af-e0eb-11f0-a6e8-0a0027000013'), 'Chaos Dungeon', 'CHARACTER', 'Daily', 1, 250, 'assets/icons/chaos_dungeon.webp'),
(UUID_TO_BIN('17820652-e0eb-11f0-a6e8-0a0027000013'), 'Guardian Raid', 'CHARACTER', 'Daily', 1, 500, 'assets/icons/guardian.png'),
(UUID_TO_BIN('17820a79-e0eb-11f0-a6e8-0a0027000013'), 'Daily Una\'s', 'CHARACTER', 'Daily', 3, 0, 'assets/icons/daily.webp'),
(UUID_TO_BIN('17820b70-e0eb-11f0-a6e8-0a0027000013'), 'Weekly Una\'s', 'CHARACTER', 'Weekly', 3, 0, 'assets/icons/weekly.webp'),
(UUID_TO_BIN('17820c2c-e0eb-11f0-a6e8-0a0027000013'), 'Chaos Gate', 'ROSTER', 'Daily', 1, 1415, 'assets/icons/chaos_gate.png'),
(UUID_TO_BIN('17820cd3-e0eb-11f0-a6e8-0a0027000013'), 'Adventure Island', 'ROSTER', 'Daily', 1, 250, 'assets/icons/co-op_quest.webp'),
(UUID_TO_BIN('17820d7b-e0eb-11f0-a6e8-0a0027000013'), 'Field Boss', 'ROSTER', 'Daily', 1, 1640, 'assets/icons/co-op_quest.webp'),
(UUID_TO_BIN('17820e14-e0eb-11f0-a6e8-0a0027000013'), 'Paradise', 'CHARACTER', 'Weekly', 5, 1580, 'assets/icons/weekly.webp')
ON DUPLICATE KEY UPDATE
    name = IF(IFNULL(name,'') <> IFNULL(VALUES(name),''), VALUES(name), name),
    type = IF(IFNULL(type,'') <> IFNULL(VALUES(type),''), VALUES(type), type),
    reset_type = IF(IFNULL(reset_type,'') <> IFNULL(VALUES(reset_type),''), VALUES(reset_type), reset_type),
    max_entries = IF(IFNULL(max_entries,'') <> IFNULL(VALUES(max_entries),''), VALUES(max_entries), max_entries),
    min_ilvl = IF(IFNULL(min_ilvl,'') <> IFNULL(VALUES(min_ilvl),''), VALUES(min_ilvl), min_ilvl),
    icon = IF(IFNULL(icon,'') <> IFNULL(VALUES(icon),''), VALUES(icon), icon);