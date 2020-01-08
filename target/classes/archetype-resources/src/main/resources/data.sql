/**
 * Author:  Vittorio Valent
 * Created: 29-ott-2019
 */

INSERT INTO ROLE(NAME) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

INSERT INTO `USER`(NOME, COGNOME, USERNAME, PASSWORD, ROLE_ID) VALUES
('Admin', 'Admin', 'admin', '$2a$10$rrbkD94xvnpUW5iinZOtGeCSv0DiYXYI2bwtPBIoY09eb6g6F6mLO',1),
('User', 'User', 'user', '$2a$10$zOTBEUIpWnHdObaFNVIzT.sFRP.T8eYU9VD26xKJJefrZk13XOrqW',1);
