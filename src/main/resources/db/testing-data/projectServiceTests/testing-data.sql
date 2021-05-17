INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (1,0,'First Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (2,0,'Second Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);


INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (3,0,'Project with members','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',false);

INSERT INTO users(username,password,enabled,email) VALUES ('artistUser1','does not matter',TRUE,'artistUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('artistUser2','does not matter',TRUE,'artistUser2@cinemaparadiso.com');

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (1,0,'Test description','Artist 1','Surname 2',TRUE,'artistUser1','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (2,0,'Test description','Artist 2','Surname 2',TRUE,'artistUser2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (3, 1);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (3, 2);


INSERT INTO users(username,password,enabled,email) VALUES ('producerUser1','does not matter',TRUE,'producerUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('producerUser2','does not matter',TRUE,'producerUser2@cinemaparadiso.com');

INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (1,0,'https://image.flaticon.com/icons/png/512/183/183349.png','producerUser1','Producer 1','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (2,0,'https://image.flaticon.com/icons/png/512/183/183349.png','producerUser2','Producer 2','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');

INSERT INTO rel_projects_producers (project_id, producer_id) VALUES (3,1);
INSERT INTO rel_projects_producers (project_id, producer_id) VALUES (3,2);



INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (4,0,'Project with members to remove','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',false);

INSERT INTO users(username,password,enabled,email) VALUES ('artistUser3','does not matter',TRUE,'artistUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('artistUser4','does not matter',TRUE,'artistUser2@cinemaparadiso.com');

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (3,0,'Test description','Artist 3','Surname',TRUE,'artistUser3','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (4,0,'Test description','Artist 4','Surname',TRUE,'artistUser4','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',20);

INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (4, 3);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (4, 4);


INSERT INTO users(username,password,enabled,email) VALUES ('producerUser3','does not matter',TRUE,'producerUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('producerUser4','does not matter',TRUE,'producerUser2@cinemaparadiso.com');

INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (3,0,'https://image.flaticon.com/icons/png/512/183/183349.png','producerUser3','Producer 3','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (4,0,'https://image.flaticon.com/icons/png/512/183/183349.png','producerUser4','Producer 4','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');

INSERT INTO rel_projects_producers (project_id, producer_id) VALUES (4,3);
INSERT INTO rel_projects_producers (project_id, producer_id) VALUES (4,4);


INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (5,0,'Unedited Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','artistUser4',false);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (6,0,'Project To Delete','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','artistUser4',false);