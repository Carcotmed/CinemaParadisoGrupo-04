INSERT INTO users(username,password,enabled,email) VALUES ('proArtistUser1','does not matter',TRUE,'proArtistUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('proArtistUser2','does not matter',TRUE,'proArtistUser2@cinemaparadiso.com');

INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','Pro User 1','Surname 2',TRUE,'proArtistUser1','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','Pro User 2','Surname 2',TRUE,'proArtistUser2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('noProArtistUser1','does not matter',TRUE,'noProArtistUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('noProArtistUser2','does not matter',TRUE,'noProArtistUser2@cinemaparadiso.com');

INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','No Pro User 1','Surname 2',FALSE,'noProArtistUser1','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','No Pro User 2','Surname 2',FALSE,'noProArtistUser2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('existingUserName','does not matter',TRUE,'existingUserName@cinemaparadiso.com');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (20,0,'Unedited Artist Description','Existing User Name','Surname 2',FALSE,'existingUserName','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('alreadyExistingUser','does not matter',TRUE,'alreadyExistingUser@cinemaparadiso.com');

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (20,0,'Test Proyect','ACCION','Test Description',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',false);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (20,20);

INSERT INTO users(username,password,enabled,email) VALUES ('userToDelete','does not matter',TRUE,'userToDelete@cinemaparadiso.com');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (21,0,'Test description','userToDelete','Surname 2',TRUE,'userToDelete','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('userWith25LeftProjects','does not matter',TRUE,'userWith25LeftProjects@cinemaparadiso.com');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (22,0,'Test description','userWith25LeftProjects','Surname 2',TRUE,'userWith25LeftProjects','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',25);

INSERT INTO users(username,password,enabled,email) VALUES ('userWith5LeftProjects','does not matter',TRUE,'userWith5LeftProjects@cinemaparadiso.com');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (23,0,'Test description','userWith5LeftProjects','Surname 2',TRUE,'userWith5LeftProjects','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',5);

INSERT INTO users(username,password,enabled,email) VALUES ('notProUser','does not matter',TRUE,'notProUser@cinemaparadiso.com');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (24,0,'Test description','notProUser','Surname 2',FALSE,'notProUser','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',5);
