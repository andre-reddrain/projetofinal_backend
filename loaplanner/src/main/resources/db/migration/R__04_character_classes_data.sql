INSERT INTO character_classes (id, type, subtype, icon) VALUES
-- Warriors
(UUID_TO_BIN('ffe20487-ded0-11f0-a6e8-0a0027000013'), 'Berserker', 'Warrior', NULL),
(UUID_TO_BIN('ffe21062-ded0-11f0-a6e8-0a0027000013'), 'Destroyer', 'Warrior', NULL),
(UUID_TO_BIN('ffe2120b-ded0-11f0-a6e8-0a0027000013'), 'Gunlancer', 'Warrior', NULL),
(UUID_TO_BIN('ffe212fe-ded0-11f0-a6e8-0a0027000013'), 'Paladin', 'Warrior', NULL),
(UUID_TO_BIN('ffe21382-ded0-11f0-a6e8-0a0027000013'), 'Slayer', 'Warrior', NULL),
(UUID_TO_BIN('ffe2142a-ded0-11f0-a6e8-0a0027000013'), 'Valkyrie', 'Warrior', NULL),
-- Mages
(UUID_TO_BIN('ffe21571-ded0-11f0-a6e8-0a0027000013'), 'Arcanist', 'Mage', NULL),
(UUID_TO_BIN('ffe215f6-ded0-11f0-a6e8-0a0027000013'), 'Bard', 'Mage', NULL),
(UUID_TO_BIN('ffe216d3-ded0-11f0-a6e8-0a0027000013'), 'Sorceress', 'Mage', NULL),
(UUID_TO_BIN('ffe2175b-ded0-11f0-a6e8-0a0027000013'), 'Summoner', 'Mage', NULL),
-- Fighters
(UUID_TO_BIN('ffe217cf-ded0-11f0-a6e8-0a0027000013'), 'Glaivier', 'Fighter', NULL),
(UUID_TO_BIN('ffe21845-ded0-11f0-a6e8-0a0027000013'), 'Scrapper', 'Fighter', NULL),
(UUID_TO_BIN('ffe218b8-ded0-11f0-a6e8-0a0027000013'), 'Soulfist', 'Fighter', NULL),
(UUID_TO_BIN('ffe2193a-ded0-11f0-a6e8-0a0027000013'), 'Wardancer', 'Fighter', NULL),
(UUID_TO_BIN('ffe219b2-ded0-11f0-a6e8-0a0027000013'), 'Striker', 'Fighter', NULL),
(UUID_TO_BIN('ffe21a2b-ded0-11f0-a6e8-0a0027000013'), 'Breaker', 'Fighter', NULL),
-- Gunners
(UUID_TO_BIN('ffe21aa1-ded0-11f0-a6e8-0a0027000013'), 'Artillerist', 'Gunner', NULL),
(UUID_TO_BIN('ffe21b1d-ded0-11f0-a6e8-0a0027000013'), 'Deadeye', 'Gunner', NULL),
(UUID_TO_BIN('ffe21b97-ded0-11f0-a6e8-0a0027000013'), 'Gunslinger', 'Gunner', NULL),
(UUID_TO_BIN('ffe21c19-ded0-11f0-a6e8-0a0027000013'), 'Machinist', 'Gunner', NULL),
(UUID_TO_BIN('ffe21ced-ded0-11f0-a6e8-0a0027000013'), 'Sharpshooter', 'Gunner', NULL),
-- Assassins
(UUID_TO_BIN('ffe21d71-ded0-11f0-a6e8-0a0027000013'), 'Deathblade', 'Assassin', NULL),
(UUID_TO_BIN('ffe21def-ded0-11f0-a6e8-0a0027000013'), 'Reaper', 'Assassin', NULL),
(UUID_TO_BIN('ffe21e62-ded0-11f0-a6e8-0a0027000013'), 'Shadowhunter', 'Assassin', NULL),
(UUID_TO_BIN('ffe21ef8-ded0-11f0-a6e8-0a0027000013'), 'Souleater', 'Assassin', NULL),
-- Specialists
(UUID_TO_BIN('ffe21f74-ded0-11f0-a6e8-0a0027000013'), 'Aeromancer', 'Specialist', NULL),
(UUID_TO_BIN('ffe21ff6-ded0-11f0-a6e8-0a0027000013'), 'Artist', 'Specialist', NULL),
(UUID_TO_BIN('ffe2207a-ded0-11f0-a6e8-0a0027000013'), 'Wildsoul', 'Specialist', NULL)
ON DUPLICATE KEY UPDATE
    type = IF(type <> VALUES(type), VALUES(type), type),
    subtype = IF(subtype <> VALUES(subtype), VALUES(subtype), subtype),
    icon = IF(icon <> VALUES(icon), VALUES(icon), icon);