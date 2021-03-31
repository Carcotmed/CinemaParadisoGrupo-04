
INSERT INTO users(username,password,enabled) VALUES ('adminTest','adminTest',TRUE), ('ivanlot','ivanlot',TRUE), ('user','user',TRUE), ('artist','artist',TRUE);

INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
INSERT INTO authorities(username,authority) VALUES ('admin','admin');

INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('1','Christopher','Nolan','12345678D','Productor exitoso y feliz con ganas de trabajar con un equipo de trabajo apasionado por el cine de terror', 'adminTest');
INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('2','Woody','Allen','19876543W','Productor con larga experiencia en películas de ciencia ficción', 'ivanlot');
INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('3','Mel','Gibson','34587666Y ','Productora con ganas de realizar un cortometraje acerca del covid y su repercusión en la vida de las personas','user');