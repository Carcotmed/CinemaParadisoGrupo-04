INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin1','$2a$10$xpgy46/5c/UsKgD1/UQNWuze5c//nH/d5ff8cigK0saMtoznD8x0K',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin2','$2a$10$lD0WmxowSo/xnSsd6rPwPQevaIu7G4UhtocWiQrLwd9bOvMF5N40Ay',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin3','$2a$10$2B0fDl/04SUIhlcpDoLHOuMq4JPIzv2AqRM6DKrjWVRL.8EQUSBe',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin4','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1pICCzZe',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin5','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1p3CCzZe',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin6','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1p2CCzZe',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin7','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1p1CCzZe',TRUE);


INSERT INTO authorities(username,authority) VALUES ('admin','admin');
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


INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (1,'pepitod','pepito1','pepito1sur',TRUE,'pepito1sum','admin','CAMERA');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (2,'pepito2d','pepito2','pepito2sur',TRUE,'pepito2sum','admin1','DIRECTOR');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (3,'pepito3d','pepito3','pepito3sur',FALSE,'pepito3sum','admin2','WRITER');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (4,'pepito4d','pepito4','pepito4sur',FALSE,'pepito4sum','admin3','ACTOR');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (5,'juanitod','juanito1','juanito1sur',TRUE,'juanito1sum','admin4','CAMERA');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (6,'juanito2d','juanito2','juanito2sur',TRUE,'juanito2sum','admin5','DIRECTOR');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (7,'juanito3d','juanito3','juanito3sur',FALSE,'juanito3sum','admin6','WRITER');
INSERT INTO artists (id,description,name,sur_name,pro,summary,username,role) VALUES (8,'juanito4d','juanito4','juanito4sur',FALSE,'juanito4sum','admin7','ACTOR');


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