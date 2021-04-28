INSERT INTO users(username,password,enabled,email) VALUES ('testArtist','does not matter',TRUE,'testArtist@cinemaparadiso.com');

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (1,0,'Cámara buscando un proyecto en el que trabajar en sus ratos libres','Test Artist Name','Artist','True','testArtist','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('testArtist2','does not matter',TRUE,'testArtist2@cinemaparadiso.com');

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (2,0,'Cámara buscando un proyecto en el que trabajar en sus ratos libres','Test Artist Name 2','Artist','True','testArtist2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (1,0,'First Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (2,0,'Second Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (3,0,'Third Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (4,0,'Fourth Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO rel_projects_artists (id, project_id, artist_id) VALUES (1,2,1);

INSERT INTO rel_projects_artists (id, project_id, artist_id) VALUES (10,4,2);
