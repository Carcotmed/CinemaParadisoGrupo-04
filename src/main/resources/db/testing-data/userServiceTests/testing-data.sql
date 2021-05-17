INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser1','does not matter',TRUE,'autoCreatedUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser2','does not matter',TRUE,'autoCreatedUser2@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('userToBeDeleted','does not matter',TRUE,'userToBeDeleted@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('userToBeRetrieved','unhashed test password',TRUE,'userToBeRetrieved@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('disabledUser','unhashed test password',FALSE,'disabledUser@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('userToChangePassword','$2a$10$4RSJP58iBz82nihTpPNObOceZSiPKRAJ4e5e7pbUYpoMY6Eanb8Y2',TRUE,'disabledUser@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('userToEnable','a',FALSE,'userToEnable@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('userToDisable','a',TRUE,'userToDisable@cinemaparadiso.com');

INSERT INTO users(username,password,enabled,email) VALUES ('testArtist','a',TRUE,'testArtist@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('testProducer','a',TRUE,'testProducer@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('testWriter','a',TRUE,'testWriter@cinemaparadiso.com');

INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (1,0,'Cámara buscando un proyecto en el que trabajar en sus ratos libres','Test Artist Name','Artist',TRUE,'testArtist','CAMARA','https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png',1);
INSERT INTO writers (version, description, name, sur_name, photo, username) VALUES (0,'Aficionado a la escritura desde que era pequeños','Test Writer Name','Bullock','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU','testWriter');
INSERT INTO producers (version, photo, username, name, description, sur_name) VALUES (0,'https://image.flaticon.com/icons/png/512/183/183349.png','testProducer','Test Producer Name','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');

INSERT INTO users(username,password,enabled,email) VALUES ('testPrincipal','a',TRUE,'testPrincipal@cinemaparadiso.com');