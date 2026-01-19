INSERT INTO raids (id, name, type, icon) VALUES
(UUID_TO_BIN('09e14bf4-dc67-11f0-a6e8-0a0027000013'), 'Argos', 'Abyss Raid', 'assets/raids/argos.webp'),
(UUID_TO_BIN('09e153ea-dc67-11f0-a6e8-0a0027000013'), 'Valtan', 'Legion Raid', 'assets/raids/valtan.webp'),
(UUID_TO_BIN('09e17f44-dc67-11f0-a6e8-0a0027000013'), 'Vykas', 'Legion Raid', 'assets/raids/vykas.webp'),
(UUID_TO_BIN('09e18275-dc67-11f0-a6e8-0a0027000013'), 'Kakul-Saydon', 'Legion Raid', 'assets/raids/kakul.webp'),
(UUID_TO_BIN('09e182dc-dc67-11f0-a6e8-0a0027000013'), 'Brelshaza', 'Legion Raid', 'assets/raids/brelshaza.webp'),
(UUID_TO_BIN('09e1832e-dc67-11f0-a6e8-0a0027000013'), 'Kayangel', 'Abyssal Dungeon', 'assets/raids/kayangel.webp'),
(UUID_TO_BIN('09e18387-dc67-11f0-a6e8-0a0027000013'), 'Akkan', 'Legion Raid', 'assets/raids/akkan.webp'),
(UUID_TO_BIN('09e183d7-dc67-11f0-a6e8-0a0027000013'), 'Ivory Tower', 'Abyssal Dungeon', 'assets/raids/ivory.webp'),
(UUID_TO_BIN('09e18430-dc67-11f0-a6e8-0a0027000013'), 'Thaemine', 'Legion Raid', 'assets/raids/thaemine.webp'),
(UUID_TO_BIN('09e1848f-dc67-11f0-a6e8-0a0027000013'), 'Overture: Echidna', 'Kazeros Raid', 'assets/raids/echidna.webp'),
(UUID_TO_BIN('09e18504-dc67-11f0-a6e8-0a0027000013'), 'Behemoth', 'Epic Raid', 'assets/raids/behemoth.webp'),
(UUID_TO_BIN('09e18571-dc67-11f0-a6e8-0a0027000013'), 'Act 1: Aegir', 'Kazeros Raid', 'assets/raids/aegir.webp'),
(UUID_TO_BIN('09e185d7-dc67-11f0-a6e8-0a0027000013'), 'Act 2: Brelshaza', 'Kazeros Raid', 'assets/raids/brelshaza2.webp'),
(UUID_TO_BIN('09e1868d-dc67-11f0-a6e8-0a0027000013'), 'Act 3: Mordum', 'Kazeros Raid', 'assets/raids/mordum.webp'),
(UUID_TO_BIN('09e18706-dc67-11f0-a6e8-0a0027000013'), 'Act 4: Armoche', 'Kazeros Raid', 'assets/raids/armoche.webp'),
(UUID_TO_BIN('09e18775-dc67-11f0-a6e8-0a0027000013'), 'Final Day: Kazeros', 'Kazeros Raid', 'assets/raids/kazeros.webp')
ON DUPLICATE KEY UPDATE
    name = IF(IFNULL(name,'') <> IFNULL(VALUES(name),''), VALUES(name), name),
    type = IF(IFNULL(type,'') <> IFNULL(VALUES(type),''), VALUES(type), type),
    icon = IF(IFNULL(icon,'') <> IFNULL(VALUES(icon),''), VALUES(icon), icon);