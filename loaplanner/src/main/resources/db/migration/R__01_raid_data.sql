INSERT INTO raids (id, name, type, icon) VALUES
(UUID_TO_BIN('09e14bf4-dc67-11f0-a6e8-0a0027000013'), 'Argos', 'Abyss Raid', null),
(UUID_TO_BIN('09e153ea-dc67-11f0-a6e8-0a0027000013'), 'Valtan', 'Legion Raid', null),
(UUID_TO_BIN('09e17f44-dc67-11f0-a6e8-0a0027000013'), 'Vykas', 'Legion Raid', null),
(UUID_TO_BIN('09e18275-dc67-11f0-a6e8-0a0027000013'), 'Kakul-Saydon', 'Legion Raid', null),
(UUID_TO_BIN('09e182dc-dc67-11f0-a6e8-0a0027000013'), 'Brelshaza', 'Legion Raid', null),
(UUID_TO_BIN('09e1832e-dc67-11f0-a6e8-0a0027000013'), 'Kayangel', 'Abyssal Dungeon', null),
(UUID_TO_BIN('09e18387-dc67-11f0-a6e8-0a0027000013'), 'Akkan', 'Legion Raid', null),
(UUID_TO_BIN('09e183d7-dc67-11f0-a6e8-0a0027000013'), 'Ivory Tower', 'Abyssal Dungeon', null),
(UUID_TO_BIN('09e18430-dc67-11f0-a6e8-0a0027000013'), 'Thaemine', 'Legion Raid', null),
(UUID_TO_BIN('09e1848f-dc67-11f0-a6e8-0a0027000013'), 'Overture: Echidna', 'Kazeros Raid', null),
(UUID_TO_BIN('09e18504-dc67-11f0-a6e8-0a0027000013'), 'Behemoth', 'Epic Raid', null),
(UUID_TO_BIN('09e18571-dc67-11f0-a6e8-0a0027000013'), 'Act 1: Aegir', 'Kazeros Raid', null),
(UUID_TO_BIN('09e185d7-dc67-11f0-a6e8-0a0027000013'), 'Act 2: Brelshaza', 'Kazeros Raid', null),
(UUID_TO_BIN('09e1868d-dc67-11f0-a6e8-0a0027000013'), 'Act 3: Mordum', 'Kazeros Raid', null),
(UUID_TO_BIN('09e18706-dc67-11f0-a6e8-0a0027000013'), 'Act 4: Armoche', 'Kazeros Raid', null),
(UUID_TO_BIN('09e18775-dc67-11f0-a6e8-0a0027000013'), 'Final Day: Kazeros', 'Kazeros Raid', null)
ON DUPLICATE KEY UPDATE
    name = IF(name <> VALUES(name), VALUES(name), name),
    type = IF(type <> VALUES(type), VALUES(type), type),
    icon = IF(icon <> VALUES(icon), VALUES(icon), icon);