INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser1','does not matter',TRUE,'autoCreatedUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser2','does not matter',TRUE,'autoCreatedUser2@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser3','does not matter',TRUE,'autoCreatedUser3@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser4','does not matter',TRUE,'autoCreatedUser4@cinemaparadiso.com');

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (1,0,'Test Issue 1','Test Body 1',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser3','autoCreatedTestUser4',false);
INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (2,0,'Test Issue 2','Test Body 2',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser3','autoCreatedTestUser4',false);

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (3,0,'Test Issue To Delete','Test Body To Delete',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser1','autoCreatedTestUser2',false);

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (1,0,'Cámara buscando un proyecto en el que trabajar en sus ratos libres','Artist','Artist','True','autoCreatedTestUser1','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (2,0,'Cámara buscando un proyecto en el que trabajar en sus ratos libres','Artist','Artist','True','autoCreatedTestUser2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO projects (id, version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (1,0,'Producciones Sevilla','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','autoCreatedTestUser2',true);

INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (1,2);

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (4,0,'Quiero unirme a su proyecto','Me gustaría entrar en su proyecto llamado Producciones Sevilla. Mi rol es CAMARA.',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser2','autoCreatedTestUser2',1);

INSERT INTO projects (id, version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (2,0,'Producciones Sevilla 2','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','autoCreatedTestUser1',true);

INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser5','does not matter',TRUE,'autoCreatedUser5@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser6','does not matter',TRUE,'autoCreatedUser6@cinemaparadiso.com');

INSERT INTO producers (id,version, photo, username, name, description, sur_name) VALUES (1,0,'https://image.flaticon.com/icons/png/512/183/183349.png','autoCreatedTestUser5','Leonard Photography','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');
INSERT INTO producers (id,version, photo, username, name, description, sur_name) VALUES (2,0,'https://image.flaticon.com/icons/png/512/183/183349.png','autoCreatedTestUser3','Leonard Photography','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');

INSERT INTO rel_projects_producers (project_id, producer_id) VALUES (1,1);
INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (5,0,'Quiero unirme a su proyecto','Me gustaría entrar en su proyecto llamado Producciones Sevilla. Mi rol es Productor.',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser5','autoCreatedTestUser2',1);

INSERT INTO stories (id,version, title, body, genre, storylength, is_sponsored,photo,numlikes) VALUES (1,0,'The Fault in Our Stars','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true,'https://espaciolibros.com//wp-content/uploads/2014/01/la-novela-y-su-definicion-600x536.jpg',0);
INSERT INTO writers (id,version, description, name, sur_name, photo, username) VALUES (1,0,'Aficionado a la escritura desde que era pequeños','Rebecca','Bullock','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU','autoCreatedTestUser6');
INSERT INTO rel_story_writers (story_id, writer_id) VALUES (1,1);


INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request,story_id) VALUES (6,0,'asd','asddassadsadasdasdads',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser2','autoCreatedTestUser2',1,1);


INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser7','does not matter',TRUE,'autoCreatedUser7@cinemaparadiso.com');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (3,0,'Cámara buscando un proyecto en el que trabajar en sus ratos libres','Artist','Artist','True','autoCreatedTestUser7','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (7,0,'asd','asdasdasdasdasdasd',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser7','autoCreatedTestUser2',1);


INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser8','does not matter',TRUE,'autoCreatedUser7@cinemaparadiso.com');
INSERT INTO producers (id,version, photo, username, name, description, sur_name) VALUES (3,0,'https://image.flaticon.com/icons/png/512/183/183349.png','autoCreatedTestUser8','Leonard Photography','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (8,0,'asd','asdasdasdasdasd',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser8','autoCreatedTestUser2',1);


INSERT INTO users(username,password,enabled,email) VALUES ('userWithMessages1','does not matter',TRUE,'autoCreatedUser7@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('userWithMessages2','does not matter',TRUE,'autoCreatedUser7@cinemaparadiso.com');

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (9,0,'asd','Test Created Body 1',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'userWithMessages1','userWithMessages2',1);
INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (10,0,'asd','Test Created Body 2',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'userWithMessages1','userWithMessages2',1);

INSERT INTO stories (id,version, title, body, genre, storylength, is_sponsored,photo,numlikes) VALUES (2,0,'The Fault in Our Stars','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true,'https://espaciolibros.com//wp-content/uploads/2014/01/la-novela-y-su-definicion-600x536.jpg',0);

INSERT INTO users(username,password,enabled,email) VALUES ('userWithMessages3','does not matter',TRUE,'autoCreatedUser7@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('userWithMessages4','does not matter',TRUE,'autoCreatedUser7@cinemaparadiso.com');

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request, story_id, seen) VALUES (11,0,'asd','Test Created Body 3',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'userWithMessages3','userWithMessages4',1,2, false);
INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request, story_id, seen) VALUES (12,0,'asd','Test Created Body 4',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'userWithMessages3','userWithMessages4',1,2, true);

