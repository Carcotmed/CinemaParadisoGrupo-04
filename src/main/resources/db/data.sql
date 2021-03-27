DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
	username varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	password varchar_ignorecase(255) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE artists(
	id INTEGER NOT NULL,
	description varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	name varchar_ignorecase(255) NOT NULL,
	sur_name varchar_ignorecase(255) NOT NULL,
	pro BOOLEAN NOT NULL,
	summary varchar_ignorecase(255) NOT NULL,
	username varchar_ignorecase(255) NOT NULL,
	role ENUM('CAMERA','WRITER','ACTOR','DIRECTOR') NOT NULL
);


INSERT INTO users(username,password,enabled) VALUES ('admin','admin',TRUE),
('adminTest','adminTest',TRUE),
('ivanlot','ivanlot',TRUE),
('user','user',TRUE),
('artist','artist',TRUE);

-- INSERT INTO artist(name,surName,roles,projects,summary,pro,user)

INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (1,'pepitod','pepito1','pepito1sur',TRUE,'pepito1sum','admin','CAMERA');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (2,'pepito2d','pepito2','pepito2sur',TRUE,'pepito2sum','admin','DIRECTOR');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (3,'pepito3d','pepito3','pepito3sur',FALSE,'pepito3sum','admin','WRITER');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (4,'pepito4d','pepito4','pepito4sur',FALSE,'pepito4sum','admin','ACTOR');


--Borrar?
--INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
--INSERT INTO authorities(username,authority) VALUES ('admin','admin');