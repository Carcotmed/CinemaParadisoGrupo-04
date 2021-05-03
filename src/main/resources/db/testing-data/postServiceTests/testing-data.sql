INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (1,0,'First Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);
INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (2,0,'Second Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);
INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (3,0,'Project with members','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',false);

INSERT INTO users(username,password,enabled,email) VALUES ('artistUser1','does not matter',TRUE,'artistUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('artistUser2','does not matter',TRUE,'artistUser2@cinemaparadiso.com');

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (1,0,'Test description','Artist 1','Surname 2','True','artistUser1','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (2,0,'Test description','Artist 2','Surname 2','True','artistUser2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (1, 1);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (2, 1);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (3, 1);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (1, 2);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (2, 2);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (3, 2);

INSERT INTO posts (id,version,title,body,date,artist_id,producer_id,project_id,username) VALUES (1,0,'Holad1','Holaddddd1',TO_DATE('26/04/2021', 'DD/MM/YYYY'),1,null,1,'artistUser1');
INSERT INTO posts (id,version,title,body,date,artist_id,producer_id,project_id,username) VALUES (2,0,'Holad2','Holaddddd2',TO_DATE('27/04/2021', 'DD/MM/YYYY'),2,null,1,'artistUser2');
INSERT INTO posts (id,version,title,body,date,artist_id,producer_id,project_id,username) VALUES (3,0,'Holad3','Holaddddd3',TO_DATE('28/04/2021', 'DD/MM/YYYY'),1,null,1,'artistUser1');
