DROP TABLE users IF EXISTS;
DROP TABLE authorities IF EXISTS;

CREATE TABLE users(
	username varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	password varchar_ignorecase(255) NOT NULL,
	enabled BOOLEAN NOT NULL
);


INSERT INTO users(username,password,enabled) VALUES ('admin','admin',TRUE),
('adminTest','adminTest',TRUE),
('ivanlot','ivanlot',TRUE),
('user','user',TRUE),
('artist','artist',TRUE);

--INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
--INSERT INTO authorities(username,authority) VALUES ('admin','admin');