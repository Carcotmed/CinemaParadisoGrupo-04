INSERT INTO users(username,password,enabled,email) VALUES ('admin0','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE,'user1@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin1','$2a$10$xpgy46/5c/UsKgD1/UQNWuze5c//nH/d5ff8cigK0saMtoznD8x0K',TRUE,'user2@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin2','$2a$10$lD0WmxowSo/xnSsd6rPwPQevaIu7G4UhtocWiQrLwd9bOvMF5N40Ay',TRUE,'user3@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin3','$2a$10$2B0fDl/04SUIhlcpDoLHOuMq4JPIzv2AqRM6DKrjWVRL.8EQUSBe',TRUE,'user4@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin4','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1pICCzZe',TRUE,'user5@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin5','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1p3CCzZe',TRUE,'user6@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin6','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1p2CCzZe',TRUE,'user7@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin7','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1p1CCzZe',TRUE,'user8@ejemplo.com');


INSERT INTO authorities(username,authority) VALUES ('admin0','admin');
INSERT INTO authorities(username,authority) VALUES ('admin1','admin');
INSERT INTO authorities(username,authority) VALUES ('admin2','admin');
INSERT INTO authorities(username,authority) VALUES ('admin3','admin');
INSERT INTO authorities(username,authority) VALUES ('admin4','admin');
INSERT INTO authorities(username,authority) VALUES ('admin5','admin');
INSERT INTO authorities(username,authority) VALUES ('admin6','admin');
INSERT INTO authorities(username,authority) VALUES ('admin7','admin');


INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (1,'De miedo','Miedo','https://i.pinimg.com/originals/73/09/3f/73093ff700637e9ce2aed290b9be255c.jpg',TRUE,2,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (2,'Ciencia ficcion','Ciencia Ficcion','https://miro.medium.com/max/2400/1*onNN4P1jCC8DyS9GxUAm1w.jpeg',TRUE,1,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (3,'De accion','Accion','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/john-wick-chapter-3-parabellum-1558983194.jpg',TRUE,0,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (4,'De Psicologica','Psicologica','https://media.gq.com.mx/photos/5e4ec0e59e37340009e81f24/16:9/w_1920,c_limit/peliculas-psicologicas-en-netflix.jpg',TRUE,3,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (5,'De humor','Humoristicas','https://elcomercio.pe/resizer/6My5hxvD2FdlVZNPT1TrNZfrUEg=/1200x900/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/SA2H5DWGFBFXBDVY5BRANX6IYA.jpg',TRUE,4,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (6,'De ficcion','Ficcion','https://i1.wp.com/cinefilosoficial.com/wp-content/uploads/2020/07/harry-potter-ficcion.jpg',TRUE,5,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (7,'Projecto de terror','Scary','https://www.elcomercio.com/files/article_main/uploads/2019/09/05/5d71926073d7d.jpeg',FALSE,2,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (8,'De galaxias','Star wars','https://i.blogs.es/37bccb/1366_2000/450_1000.jpeg',FALSE,1,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (9,'De tiroteos','Juan bond','https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2019/12/10/15760116146075.jpg',FALSE,0,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (10,'Una vidente te lee la mente','Veo tu futuro','https://www.ecestaticos.com/image/clipping/868e66d9da6a671cab0b69f31baf93b3/los-trucos-que-utilizan-los-videntes-para-enganarte-contados-por-una-de-ellos.jpg',FALSE,3,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (11,'Para partirte de risa','Mortadelo y Filemon Indie','https://estaticos.muyhistoria.es/media/cache/1140x_thumb/uploads/images/ephemeris/5e04bfc55cafe8c5f6f862fe/mortadelo-filemon_0.jpg',FALSE,4,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (12,'Ficcion total','Futurismo','https://estaticos.muyinteresante.es/media/cache/760x570_thumb/uploads/images/gallery/5c0fc5e35cafe803d35b883b/peliculas-2019_0.jpg',FALSE,5,0);
INSERT INTO projects (id,description,title,photo,pro,genre,version) VALUES (13,'Locuras Extremas','Futurismo','http://pxsports.com/wp-content/uploads/2016/12/francia-1.jpg',FALSE,5,0);


INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (1,'pepitod','pepito1','pepito1sur',TRUE,'pepito1sum','admin0','CAMERA','https://i.blogs.es/5efe2c/cap_001/450_1000.jpg');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (2,'pepito2d','pepito2','pepito2sur',TRUE,'pepito2sum','admin1','DIRECTOR','https://empresas.blogthinkbig.com/wp-content/uploads/2019/11/Imagen3-245003649.jpg?w=800');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (3,'pepito3d','pepito3','pepito3sur',FALSE,'pepito3sum','admin2','WRITER','https://e00-marca.uecdn.es/assets/multimedia/imagenes/2020/04/08/15863374252712.jpg');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (4,'pepito4d','pepito4','pepito4sur',FALSE,'pepito4sum','admin3','ACTOR','https://3.bp.blogspot.com/-JfL1o7oSnKI/VmodObHF9cI/AAAAAAAABLY/nKKRXw0-yiU/s1600/homero_456_336.jpg');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (5,'juanitod','juanito1','juanito1sur',TRUE,'juanito1sum','admin4','CAMERA','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3pGX4MsvahQ6lazFvLB5q5gM1hutnF_erdg&usqp=CAU');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (6,'juanito2d','juanito2','juanito2sur',TRUE,'juanito2sum','admin5','DIRECTOR','https://cdn.shopify.com/s/files/1/0229/0839/files/Busqueda_de_imagenes_3_large.jpg?v=1578328497');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (7,'juanito3d','juanito3','juanito3sur',FALSE,'juanito3sum','admin6','WRITER','https://imagenes.milenio.com/frnpuakaet1zMB01a5O8Fl9YbRk=/958x596/https://www.milenio.com/uploads/media/2020/06/26/la-imagen-completa-esta-mas-2_0_167_319_198.jpg');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role,photo) VALUES (8,'juanito4d','juanito4','juanito4sur',FALSE,'juanito4sum','admin7','ACTOR','https://dam.ngenespanol.com/wp-content/uploads/2019/03/luna-colores-nuevo.png');


INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (1,1,1);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (2,2,1);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (3,3,1);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (4,1,2);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (5,4,2);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (6,5,1);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (7,6,1);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (8,7,1);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (9,5,2);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (10,8,2);
INSERT INTO rel_projects_artists (id,artist_id, project_id) VALUES (11,1,13);

INSERT INTO messages(id,version,issue,body,messageDate,emisor_id,receptor_id) VALUES (1,0,'Bienvenido','He escuchado que acabas de entrar en la pagina, que tal te va?',TO_DATE('28/03/2021', 'DD/MM/YYYY'),'admin0', 'admin1');
INSERT INTO messages(id,version,issue,body,messageDate,emisor_id,receptor_id) VALUES (2,0,'Me encanta esto','Bastante bien, me esta encantando como funciona, cuanto tiempo llevas aqui?',TO_DATE('29/03/2021', 'DD/MM/YYYY'),'admin2', 'admin3');
INSERT INTO messages(id,version,issue,body,messageDate,emisor_id,receptor_id) VALUES (3,0,'Pues si','Llevo aqui apenas 2 semanas, pero es como si llevara toda la vida de lo facil de usar que es',TO_DATE('30/03/2021', 'DD/MM/YYYY'),'admin4', 'admin5');

