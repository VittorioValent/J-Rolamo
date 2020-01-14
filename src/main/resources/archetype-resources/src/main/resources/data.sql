/**
 * Author:  Vittorio Andreoni
 * Created: 29-ott-2019
 */

INSERT INTO ROLE(NAME) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

/* Password: string, admin, string */
INSERT INTO `USER`(NOME, COGNOME, USERNAME, PASSWORD, ROLE_ID, OWNER, CREATED_ON, LAST_MODIFIED_BY, LAST_MODIFIED_ON) VALUES
('Admin', 'Admin', 'admin', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1, 'admin', '2019-10-29 10:00:00', 'admin', '2019-10-29 10:00:00'),
('String', 'String', 'string', '$2a$10$1yFOHygg9SDqog9Jr7EdqeNnnJ6xI1ycrS/Z1EECg47orIvhZLsx6',1, 'string', '2019-10-29 10:00:00', 'string', '2019-10-29 10:00:00');
