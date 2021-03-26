CREATE TABLE users(
	username varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	password varchar_ignorecase(255) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE artists(
	description varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	name varchar_ignorecase(255) NOT NULL,
	sur_name varchar_ignorecase(255) NOT NULL,
	pro BOOLEAN NOT NULL,
	summary varchar_ignorecase(255) NOT NULL,
	username varchar_ignorecase(255) NOT NULL
);


INSERT INTO users(username,password,enabled) VALUES ('admin','admin',TRUE),
('adminTest','adminTest',TRUE),
('ivanlot','ivanlot',TRUE),
('user','user',TRUE),
('artist','artist',TRUE);

-- INSERT INTO artist(name,surName,roles,projects,summary,pro,user)

INSERT INTO artists (description,name,sur_name,role,pro,summary,username) VALUES ('pepitod','pepito1','pepito1sur',TRUE,'pepito1sum','admin');
INSERT INTO artists (description,name,sur_name,role,pro,summary,username) VALUES ('pepito2d','pepito2','pepito2sur',TRUE,'pepito2sum','admin');
INSERT INTO artists (description,name,sur_name,pro,summary,username) VALUES ('pepito3d','pepito3','pepito3sur',FALSE,'pepito3sum','admin');
INSERT INTO artists (description,name,sur_name,pro,summary,username) VALUES ('pepito4d','pepito4','pepito4sur',FALSE,'pepito4sum','admin');



-- INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
-- INSERT INTO authorities(username,authority) VALUES ('admin','admin');