INSERT INTO users (username,password,enabled,email) VALUES ('FrancisHolder','$2y$10$UN0qXXYHTvg7wH.4hJntxOUuGcyamkkZmlzyHOWiVa.GEjbZ95Pai',TRUE,'lacus.Nulla@ametultricies.ca');
INSERT INTO users (username,password,enabled,email) VALUES ('EmiLogan','$2y$10$7gixBjR6kP2g.wPf3ru.H.qpB0huhuhBQY./iyDSgulPu0dRiAcsC',TRUE,'vehicula.et@sedfacilisis.co.uk');
INSERT INTO users (username,password,enabled,email) VALUES ('LeeRobertson','$2y$10$u05oV/1Mwwrx.oCED1muR.s0Qaa5OBApc2tH2KNfWQnZw7M9cu0RG',FALSE,'feugiat.Sed@aliquamarcuAliquam.ca');
INSERT INTO users (username,password,enabled,email) VALUES ('FlorenceCooper','$2y$10$A4xR5/LVTMn4I.KuG7nWIudc94g7YWQgUiwFAPEI7m5ZIM5xivSp2',TRUE,'dolor.dolor.tempus@Crasconvallis.co.uk');
INSERT INTO users (username,password,enabled,email) VALUES ('HayesBenton','$2y$10$fuJyFOVeQ0ubEhss.tAh1OnEcEDEU6IaNyHNobGV/7rzxCYSlRsgK',TRUE,'dolor@erat.com');

INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (1,0,'https://image.flaticon.com/icons/png/512/183/183349.png','FrancisHolder','Leonard Photography','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Horton');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (2,0,'https://image.flaticon.com/icons/png/512/183/183349.png','EmiLogan','Ellis Reproductions','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Hines');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (3,0,'https://image.flaticon.com/icons/png/512/183/183349.png','LeeRobertson','Adderley Distribution','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Kelly');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (4,0,'https://image.flaticon.com/icons/png/512/183/183349.png','FlorenceCooper','Bates Coachworks','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Hampton');
INSERT INTO producers (id, version, photo, username, name, description, sur_name) VALUES (5,0,'https://image.flaticon.com/icons/png/512/183/183349.png','HayesBenton','Gatfield Photography','Empresa productora de peliculas, buscamos artistas nuevos en el sector','Kline');

INSERT INTO authorities (username, authority) VALUES ('FrancisHolder','producer');
INSERT INTO authorities (username, authority) VALUES ('EmiLogan','producer');
INSERT INTO authorities (username, authority) VALUES ('LeeRobertson','producer');
INSERT INTO authorities (username, authority) VALUES ('FlorenceCooper','producer');
INSERT INTO authorities (username, authority) VALUES ('HayesBenton','producer');

INSERT INTO users (username,password,enabled,email) VALUES ('JarrodHuffman','$2y$10$qJ14yJUo2/iXDiZrH17WPO1nx1AVeazpJJtleKKK/qr1iPamDdekC',TRUE,'habitant.morbi.tristique@cursusNuncmauris.org');
INSERT INTO artists (id,version,description,name,sur_name,pro,username,role,photo,left_projects) VALUES (2,0,'Actor novato apasionado por el mundillo','Jarrod','Huffman',TRUE,'JarrodHuffman','ACTOR','https://image.freepik.com/foto-gratis/retrato-joven-sonriente-gafas_171337-4842.jpg',1);
INSERT INTO authorities (username, authority) VALUES ('JarrodHuffman', 'artist');
INSERT INTO projects (id, version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (1,0,'Producciones Sevilla','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',false,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',false);
INSERT INTO rel_projects_producers (project_id, producer_id) VALUES (1,1);