
--INSERT INTO users(username,password,enabled) VALUES ('adminTest','adminTest',TRUE), ('ivanlot','ivanlot',TRUE), ('user','user',TRUE), ('artist','artist',TRUE);

INSERT INTO users(username,password,enabled,email) VALUES ('adminTest','$2a$10$xpgy46/5c/UsKgD1/UQNWuze5c//nH/d5ff8cigK0saMtoznD8x0K',TRUE,'user1@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('ivanlot','$2a$10$lD0WmxowSo/xSsd6rPwPQevaIu7G4UhtocWiQrLwd9bOvMF5N40Ay',TRUE,'user2@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('user','$2a$10$2B0fDl/04SUIhlcpDoLHOunMq4JPIzv2AqRM6DKrjWVRL.8EQUSBe',TRUE,'user3@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('artist','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1pICCzZe',TRUE,'user4@ejemplo.com');
INSERT INTO users(username,password,enabled,email) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE,'user5@ejemplo.com');
INSERT INTO authorities(username,authority) VALUES ('admin','admin');

INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('1','Christopher','Nolan','12345678D','Productor exitoso y feliz con ganas de trabajar con un equipo de trabajo apasionado por el cine de terror', 'adminTest');
INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('2','Woody','Allen','19876543W','Productor con larga experiencia en películas de ciencia ficción', 'ivanlot');
INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('3','Mel','Gibson','34587666Y ','Productora con ganas de realizar un cortometraje acerca del covid y su repercusión en la vida de las personas','user');


INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (1,'De miedo','Miedo','https://i.pinimg.com/originals/73/09/3f/73093ff700637e9ce2aed290b9be255c.jpg',TRUE,2);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (2,'Ciencia ficcion','Ciencia Ficcion','https://miro.medium.com/max/2400/1*onNN4P1jCC8DyS9GxUAm1w.jpeg',TRUE,1);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (3,'De accion','Accion','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/john-wick-chapter-3-parabellum-1558983194.jpg',TRUE,0);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (4,'De Psicologica','Psicologica','https://media.gq.com.mx/photos/5e4ec0e59e37340009e81f24/16:9/w_1920,c_limit/peliculas-psicologicas-en-netflix.jpg',TRUE,3);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (5,'De humor','Humoristicas','https://elcomercio.pe/resizer/6My5hxvD2FdlVZNPT1TrNZfrUEg=/1200x900/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/SA2H5DWGFBFXBDVY5BRANX6IYA.jpg',TRUE,4);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (6,'De ficcion','Ficcion','https://i1.wp.com/cinefilosoficial.com/wp-content/uploads/2020/07/harry-potter-ficcion.jpg',TRUE,5);

INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (7,'Projecto de terror','Scary','https://www.elcomercio.com/files/article_main/uploads/2019/09/05/5d71926073d7d.jpeg',FALSE,2);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (8,'De galaxias','Star wars','https://i.blogs.es/37bccb/1366_2000/450_1000.jpeg',FALSE,1);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (9,'De tiroteos','Juan bond','https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2019/12/10/15760116146075.jpg',FALSE,0);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (10,'Una vidente te lee la mente','Veo tu futuro','https://www.ecestaticos.com/image/clipping/868e66d9da6a671cab0b69f31baf93b3/los-trucos-que-utilizan-los-videntes-para-enganarte-contados-por-una-de-ellos.jpg',FALSE,3);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (11,'Para partirte de risa','Mortadelo y Filemon Indie','https://estaticos.muyhistoria.es/media/cache/1140x_thumb/uploads/images/ephemeris/5e04bfc55cafe8c5f6f862fe/mortadelo-filemon_0.jpg',FALSE,4);
INSERT INTO projects (id,description,title,photo,pro,genre) VALUES (12,'Ficcion total','Futurismo','https://estaticos.muyinteresante.es/media/cache/760x570_thumb/uploads/images/gallery/5c0fc5e35cafe803d35b883b/peliculas-2019_0.jpg',FALSE,5);

--INSERT INTO stories (id,version,title,body,genre,storylength) VALUE (1,1,'La historia interminable','MUCHO TEXTO','SCIFI',10);
--INSERT INTO stories (id,version,title,body,genre,storylength) VALUE	(2,2, 'Piratas del Caribe','MUCHO TEXTO','ACTIONN',2);
--INSERT INTO stories (id,version,title,body,genre,storylength) VALUE	(3,3, 'Harry Potter y la piedra filosofal','MUCHO TEXTO','FICTION',2);
--INSERT INTO stories (id,version,title,body,genre,storylength) VALUE	(4,4, 'En mundo de Gullyver','MUCHO TEXTO','FICTION',1);
--INSERT INTO stories (id,version,title,body,genre,storylength) VALUE	(5,5, 'Jurassic Park','MUCHO TEXTO','SCIFI',2);
--INSERT INTO stories (id,version,title,body,genre,storylength) VALUE	(6,6, 'SlumDog Millionaire','MUCHO TEXTO','PSYCHOLOGIC',3);
--INSERT INTO stories (id,version,title,body,genre,storylength) VALUE	(7,7, 'Cadena Perpetua','MUCHO TEXTO','PSYCHOLOGIC',2);
--
--INSERT INTO rel_story_projects (story_id, project_id) VALUES (1,1);
--INSERT INTO rel_story_projects (story_id, project_id) VALUES (2,2);
--INSERT INTO rel_story_projects (story_id, project_id) VALUES (3,3);
--INSERT INTO rel_story_projects (story_id, project_id) VALUES (4,5);
--INSERT INTO rel_story_projects (story_id, project_id) VALUES (5,4);
--INSERT INTO rel_story_projects (story_id, project_id) VALUES (6,6);
--INSERT INTO rel_story_projects (story_id, project_id) VALUES (7,7);

INSERT INTO messages(issue,body,date,emisor_id,receptor_id) VALUES ('Bienvenido','He escuchado que acabas de entrar en la pagina, que tal te va?',TO_DATE('28/03/2021', 'DD/MM/YYYY'),'user', 'ivanlot');
INSERT INTO messages(issue,body,date,emisor_id,receptor_id) VALUES ('Me encanta esto','Bastante bien, me esta encantando como funciona, cuanto tiempo llevas aqui?',TO_DATE('29/03/2021', 'DD/MM/YYYY'),'ivanlot', 'user');
INSERT INTO messages(issue,body,date,emisor_id,receptor_id) VALUES ('Pues si','Llevo aqui apenas 2 semanas, pero es como si llevara toda la vida de lo facil de usar que es',TO_DATE('30/03/2021', 'DD/MM/YYYY'),'user', 'ivanlot');

