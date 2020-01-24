/**
 * Author:  Vittorio Andreoni
 * Created: 29-ott-2019
 */

INSERT INTO ROLE(NAME) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

/* Password: string, admin, string */
INSERT INTO `USER`(NAME, SURNAME, USERNAME, PASSWORD, ROLE_ID, OWNER, CREATED_ON, LAST_MODIFIED_BY, LAST_MODIFIED_ON) VALUES
('Franco', 'Bevilacqua', 'admin', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Giovanni', 'San', 'admin1', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Remo', 'Labarca', 'admin2', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Guido', 'Lacorriera', 'admin3', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Aldo', 'GiovannieGiacomo', 'admin4', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Lorem', 'Ipsum', 'admin5', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Genius', 'Lampadae', 'admin6', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Vittorio', 'Valent', 'admin7', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Alì', 'Mentari', 'admin8', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Furgon', 'Chin', 'admin9', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Stofinendo', 'Inomi', 'admin10', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Admin', 'Admin', 'admin11', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Admin', 'Admin', 'admin12', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Admin', 'Admin', 'admin13', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Admin', 'Admin', 'admin14', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Admin', 'Admin', 'admin15', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('Admin', 'Admin', 'admin16', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('String', 'String', 'string', '$2a$10$1yFOHygg9SDqog9Jr7EdqeNnnJ6xI1ycrS/Z1EECg47orIvhZLsx6',1, 'string', '2019-10-29 10:00:00', 'string', '2019-10-29 10:00:00');

INSERT INTO ENTITY_INFO (ID, AUDITABLE, CONTROLLER_TYPE, ENTITY_NAME, SERVICE_TYPE) VALUES 
(1,TRUE,1,'user',2),
(2,FALSE,0,'role',0);

INSERT INTO FIELD_INFO (ID, NAME, TYPE, TO_DISPLAY, TO_FILTER, ENTITY_INFO_ID) VALUES 
(1, 'id', 'Long', TRUE,TRUE, 1),
(2, 'name', 'String', TRUE,TRUE, 1),
(3, 'surname', 'String', TRUE,TRUE, 1),
(4, 'username', 'String', TRUE,FALSE, 1),
(5, 'password', 'String', FALSE,FALSE, 1),
(6, 'role', 'Role',FALSE, FALSE, 1),
(7, 'id', 'Long', TRUE,TRUE, 2),
(8, 'name', 'String', TRUE,TRUE, 2);
