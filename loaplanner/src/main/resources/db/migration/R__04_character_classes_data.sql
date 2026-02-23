INSERT INTO character_classes (id, type, subtype, icon) VALUES
-- Warriors
(UUID_TO_BIN('ffe20487-ded0-11f0-a6e8-0a0027000013'), 'Berserker', 'Warrior', 'assets/classes/warrior/berserker.png'),
(UUID_TO_BIN('ffe21062-ded0-11f0-a6e8-0a0027000013'), 'Destroyer', 'Warrior', 'assets/classes/warrior/destroyer.png'),
(UUID_TO_BIN('ffe2120b-ded0-11f0-a6e8-0a0027000013'), 'Gunlancer', 'Warrior', 'assets/classes/warrior/gunlancer.png'),
(UUID_TO_BIN('ffe212fe-ded0-11f0-a6e8-0a0027000013'), 'Paladin', 'Warrior', 'assets/classes/warrior/paladin.png'),
(UUID_TO_BIN('ffe21382-ded0-11f0-a6e8-0a0027000013'), 'Slayer', 'Warrior', 'assets/classes/warrior/slayer.png'),
(UUID_TO_BIN('ffe2142a-ded0-11f0-a6e8-0a0027000013'), 'Valkyrie', 'Warrior', 'assets/classes/warrior/valkyrie.png'),
-- Mages
(UUID_TO_BIN('ffe21571-ded0-11f0-a6e8-0a0027000013'), 'Arcanist', 'Mage', 'assets/classes/mage/arcanist.png'),
(UUID_TO_BIN('ffe215f6-ded0-11f0-a6e8-0a0027000013'), 'Bard', 'Mage', 'assets/classes/mage/bard.png'),
(UUID_TO_BIN('ffe216d3-ded0-11f0-a6e8-0a0027000013'), 'Sorceress', 'Mage', 'assets/classes/mage/sorceress.png'),
(UUID_TO_BIN('ffe2175b-ded0-11f0-a6e8-0a0027000013'), 'Summoner', 'Mage', 'assets/classes/mage/summoner.png'),
-- Fighters
(UUID_TO_BIN('ffe217cf-ded0-11f0-a6e8-0a0027000013'), 'Glaivier', 'Fighter', 'assets/classes/fighter/glaivier.png'),
(UUID_TO_BIN('ffe21845-ded0-11f0-a6e8-0a0027000013'), 'Scrapper', 'Fighter', 'assets/classes/fighter/scrapper.png'),
(UUID_TO_BIN('ffe218b8-ded0-11f0-a6e8-0a0027000013'), 'Soulfist', 'Fighter', 'assets/classes/fighter/soulfist.png'),
(UUID_TO_BIN('ffe2193a-ded0-11f0-a6e8-0a0027000013'), 'Wardancer', 'Fighter', 'assets/classes/fighter/wardancer.png'),
(UUID_TO_BIN('ffe219b2-ded0-11f0-a6e8-0a0027000013'), 'Striker', 'Fighter', 'assets/classes/fighter/striker.png'),
(UUID_TO_BIN('ffe21a2b-ded0-11f0-a6e8-0a0027000013'), 'Breaker', 'Fighter', 'assets/classes/fighter/breaker.png'),
-- Gunners
(UUID_TO_BIN('ffe21aa1-ded0-11f0-a6e8-0a0027000013'), 'Artillerist', 'Gunner', 'assets/classes/gunner/artillerist.png'),
(UUID_TO_BIN('ffe21b1d-ded0-11f0-a6e8-0a0027000013'), 'Deadeye', 'Gunner', 'assets/classes/gunner/deadeye.png'),
(UUID_TO_BIN('ffe21b97-ded0-11f0-a6e8-0a0027000013'), 'Gunslinger', 'Gunner', 'assets/classes/gunner/gunslinger.png'),
(UUID_TO_BIN('ffe21c19-ded0-11f0-a6e8-0a0027000013'), 'Machinist', 'Gunner', 'assets/classes/gunner/machinist.png'),
(UUID_TO_BIN('ffe21ced-ded0-11f0-a6e8-0a0027000013'), 'Sharpshooter', 'Gunner', 'assets/classes/gunner/sharpshooter.png'),
-- Assassins
(UUID_TO_BIN('ffe21d71-ded0-11f0-a6e8-0a0027000013'), 'Deathblade', 'Assassin', 'assets/classes/assassin/deathblade.png'),
(UUID_TO_BIN('ffe21def-ded0-11f0-a6e8-0a0027000013'), 'Reaper', 'Assassin', 'assets/classes/assassin/reaper.png'),
(UUID_TO_BIN('ffe21e62-ded0-11f0-a6e8-0a0027000013'), 'Shadowhunter', 'Assassin', 'assets/classes/assassin/shadowhunter.png'),
(UUID_TO_BIN('ffe21ef8-ded0-11f0-a6e8-0a0027000013'), 'Souleater', 'Assassin', 'assets/classes/assassin/souleater.png'),
-- Specialists
(UUID_TO_BIN('ffe21f74-ded0-11f0-a6e8-0a0027000013'), 'Aeromancer', 'Specialist', 'assets/classes/specialist/aeromancer.png'),
(UUID_TO_BIN('ffe21ff6-ded0-11f0-a6e8-0a0027000013'), 'Artist', 'Specialist', 'assets/classes/specialist/artist.png'),
(UUID_TO_BIN('ffe2207a-ded0-11f0-a6e8-0a0027000013'), 'Wildsoul', 'Specialist', 'assets/classes/specialist/wildsoul.png')
ON DUPLICATE KEY UPDATE
    type = IF(IFNULL(type,'') <> IFNULL(VALUES(type),''), VALUES(type), type),
    subtype = IF(IFNULL(subtype,'') <> IFNULL(VALUES(subtype),''), VALUES(subtype), subtype),
    icon = IF(IFNULL(icon,'') <> IFNULL(VALUES(icon),''), VALUES(icon), icon);