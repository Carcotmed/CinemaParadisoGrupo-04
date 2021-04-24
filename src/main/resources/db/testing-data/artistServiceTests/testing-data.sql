INSERT INTO users(username,password,enabled,email) VALUES ('proArtistUser1','does not matter',TRUE,'proArtistUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('proArtistUser2','does not matter',TRUE,'proArtistUser2@cinemaparadiso.com');

INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','Pro User 1','Surname 2','True','proArtistUser1','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','Pro User 2','Surname 2','True','proArtistUser2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('noProArtistUser1','does not matter',TRUE,'noProArtistUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('noProArtistUser2','does not matter',TRUE,'noProArtistUser2@cinemaparadiso.com');

INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','No Pro User 1','Surname 2','False','noProArtistUser1','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO artists (version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (0,'Test description','No Pro User 2','Surname 2','False','noProArtistUser2','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('existingUserName','does not matter',TRUE,'existingUserName@cinemaparadiso.com');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (20,0,'Test description','Existing User Name','Surname 2','True','existingUserName','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);

INSERT INTO users(username,password,enabled,email) VALUES ('alreadyExistingUser','does not matter',TRUE,'alreadyExistingUser@cinemaparadiso.com');

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (20,0,'Test Proyect','ACCION','Test Description',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',false);
INSERT INTO rel_projects_artists (project_id, artist_id) VALUES (20,20);

