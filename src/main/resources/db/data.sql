CREATE TABLE users(
	username varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	password varchar_ignorecase(255) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE projects(
	id INTEGER NOT NULL,
	description varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	title varchar_ignorecase(255) NOT NULL,
	photo varchar_ignorecase(255) NOT NULL,
	pro BOOLEAN NOT NULL,
	genre ENUM('ACTION',
	'SCIFI',
	'TERROR',
	'PSYCHOLOGIC',
	'HUMORISTIC',
	'FICTION') NOT NULL
);

INSERT INTO users(username,password,enabled) VALUES ('admin','admin',TRUE),
('adminTest','adminTest',TRUE),
('ivanlot','ivanlot',TRUE),
('user','user',TRUE),
('artist','artist',TRUE);


INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (1,'De miedo','Miedo','https://i.pinimg.com/originals/73/09/3f/73093ff700637e9ce2aed290b9be255c.jpg',TRUE,2);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (2,'Ciencia ficcion','Ciencia Ficcion','https://miro.medium.com/max/2400/1*onNN4P1jCC8DyS9GxUAm1w.jpeg',TRUE,1);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (3,'De accion','Accion','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/john-wick-chapter-3-parabellum-1558983194.jpg',FALSE,0);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (4,'De Psicologica','Psicologica','https://media.gq.com.mx/photos/5e4ec0e59e37340009e81f24/16:9/w_1920,c_limit/peliculas-psicologicas-en-netflix.jpg',FALSE,3);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (5,'De humor','Humoristicas','https://elcomercio.pe/resizer/6My5hxvD2FdlVZNPT1TrNZfrUEg=/1200x900/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/SA2H5DWGFBFXBDVY5BRANX6IYA.jpg',TRUE,4);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (6,'De ficcion','Ficcion','https://i1.wp.com/cinefilosoficial.com/wp-content/uploads/2020/07/harry-potter-ficcion.jpg',TRUE,5);


--INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
--INSERT INTO authorities(username,authority) VALUES ('admin','admin');