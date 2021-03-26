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

INSERT INTO artists (description,name,sur_name,pro,summary,username) VALUES ('pepito','pepito','pepito',TRUE,'pepito','artist');


-- INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
-- INSERT INTO authorities(username,authority) VALUES ('admin','admin');