INSERT IGNORE INTO airport VALUES (1, 'CHC', 'Christchurch');
INSERT IGNORE INTO airport VALUES (2, 'WLG', 'Wellington');
INSERT IGNORE INTO airport VALUES (3, 'AUK', 'Auckland');
INSERT IGNORE INTO airport VALUES (4, 'PMN', 'Palmerston North');
INSERT IGNORE INTO airport VALUES (5, 'MTN', 'Masterton');
INSERT IGNORE INTO airport VALUES (6, 'QNN', 'Queenstown');
INSERT IGNORE INTO airport VALUES (7, 'HMM', 'Hamilton');
INSERT IGNORE INTO airport VALUES (8, 'NAP', 'Napier');

INSERT IGNORE INTO airline VALUES (1, 'ANZ', 'Air New Zealand');
INSERT IGNORE INTO airline VALUES (2, 'QST', 'Jet Star');
INSERT IGNORE INTO airline VALUES (3, 'SND', 'Sounds Air');
INSERT IGNORE INTO airline VALUES (4, 'ORP', 'Origin Pacific');
INSERT IGNORE INTO airline VALUES (5, 'VNN', 'Vincent Aviation');
INSERT IGNORE INTO airline VALUES (6, 'ANN', 'Air Nelson');

INSERT IGNORE INTO flight VALUES (1,  1,  '2020-02-21', '08:00:00');
INSERT IGNORE INTO flight VALUES (2,  2,  '2020-02-10', '08:30:00');
INSERT IGNORE INTO flight VALUES (3,  3,  '2020-02-11', '09:45:00');
INSERT IGNORE INTO flight VALUES (4,  4,  '2020-02-12', '10:00:00');
INSERT IGNORE INTO flight VALUES (5,  5,  '2020-02-13', '10:30:00');
INSERT IGNORE INTO flight VALUES (6,  6,  '2020-02-14', '11:20:00');
INSERT IGNORE INTO flight VALUES (7,  7,  '2020-02-15', '12:15:00');
INSERT IGNORE INTO flight VALUES (8,  8,  '2020-02-16', '13:00:00');
INSERT IGNORE INTO flight VALUES (9,  9,  '2020-02-17', '13:25:00');
INSERT IGNORE INTO flight VALUES (10, 10, '2020-02-18', '14:50:00');
INSERT IGNORE INTO flight VALUES (11, 11, '2020-02-19', '15:00:00');
INSERT IGNORE INTO flight VALUES (12, 12, '2020-02-20', '15:35:00');
INSERT IGNORE INTO flight VALUES (13, 13, '2020-02-21', '16:00:00');

INSERT IGNORE INTO route VALUES (1,  '1234', '08:00:00', 1, 1, 1);
INSERT IGNORE INTO route VALUES (2,  '1235', '08:30:00', 1, 6, 2);
INSERT IGNORE INTO route VALUES (3,  '1236', '09:45:00', 1, 2, 3);
INSERT IGNORE INTO route VALUES (4,  '1237', '10:00:00', 1, 2, 3);
INSERT IGNORE INTO route VALUES (5,  '1238', '10:30:00', 1, 3, 4);
INSERT IGNORE INTO route VALUES (6,  '1239', '11:20:00', 1, 4, 5);
INSERT IGNORE INTO route VALUES (7,  '1240', '12:15:00', 1, 1, 6);
INSERT IGNORE INTO route VALUES (8,  '1241', '13:00:00', 1, 1, 6);
INSERT IGNORE INTO route VALUES (9,  '1242', '13:25:00', 1, 5, 7);
INSERT IGNORE INTO route VALUES (10, '1243', '14:50:00', 1, 2, 8);
INSERT IGNORE INTO route VALUES (11, '1244', '15:00:00', 1, 5, 7);
INSERT IGNORE INTO route VALUES (12, '1245', '15:35:00', 1, 2, 3);
INSERT IGNORE INTO route VALUES (13, '1246', '16:00:00', 1, 1, 4);
