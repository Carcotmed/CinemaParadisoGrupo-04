INSERT INTO users(username,password,enabled,email) VALUES ('testArtist','does not matter',TRUE,'testArtist@cinemaparadiso.com');

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (1,0,'Cámara buscando un proyecto en el que trabajar en sus ratos libres','Test Artist Name','Artist',TRUE,'testArtist','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (1,0,'First Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','testArtist',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (2,0,'Second Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','testArtist',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (3,0,'Third Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','testArtist',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (4,0,'Fourth Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','testArtist',true);

INSERT INTO rel_projects_artists (id, project_id, artist_id) VALUES (1,1,1);
INSERT INTO rel_projects_artists (id, project_id, artist_id) VALUES (2,2,1);
INSERT INTO rel_projects_artists (id, project_id, artist_id) VALUES (3,3,1);
INSERT INTO rel_projects_artists (id, project_id, artist_id) VALUES (4,4,1);

INSERT INTO users (username,password,enabled,email) VALUES ('FrancisHolder','$2y$10$UN0qXXYHTvg7wH.4hJntxOUuGcyamkkZmlzyHOWiVa.GEjbZ95Pai',TRUE,'lacus.Nulla@ametultricies.ca');
INSERT INTO users (username,password,enabled,email) VALUES ('EmiLogan','$2y$10$7gixBjR6kP2g.wPf3ru.H.qpB0huhuhBQY./iyDSgulPu0dRiAcsC',TRUE,'vehicula.et@sedfacilisis.co.uk');
INSERT INTO users (username,password,enabled,email) VALUES ('LeeRobertson','$2y$10$u05oV/1Mwwrx.oCED1muR.s0Qaa5OBApc2tH2KNfWQnZw7M9cu0RG',FALSE,'feugiat.Sed@aliquamarcuAliquam.ca');

INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (1,0,'https://image.flaticon.com/icons/png/512/183/183349.png','FrancisHolder','Leonard Photography','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (2,0,'https://image.flaticon.com/icons/png/512/183/183349.png','EmiLogan','Ellis Reproductions','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Hines');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (3,0,'https://image.flaticon.com/icons/png/512/183/183349.png','LeeRobertson','Adderley Distribution','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Kelly');

INSERT INTO authorities (username, authority) VALUES ('FrancisHolder','producer');
INSERT INTO authorities (username, authority) VALUES ('EmiLogan','producer');
INSERT INTO authorities (username, authority) VALUES ('LeeRobertson','producer');

INSERT INTO rel_projects_producers (id, project_id, producer_id) VALUES (1,1,1);
INSERT INTO rel_projects_producers (id, project_id, producer_id) VALUES (2,1,2);