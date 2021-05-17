INSERT INTO users (username,password,enabled,email) VALUES ('GradyManning','$2a$10$U9tzLPiS43F9SNtgGoYS5ekMLDj1BqxpcJNPeJrkvx59h1AWCFa',TRUE,'odio.a@musAeneaneget.co.uk');
INSERT INTO writers (version, description, name, sur_name, photo, username) VALUES (0,'Aficionado a la escritura desde que era pequeños','Rebecca','Bullock','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU','GradyManning');
INSERT INTO authorities (username, authority) VALUES ('GradyManning','writer');

INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (1,0,'The Fault in Our Stars','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true);
INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (2,0,'Gone Girl','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, false);
INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (3,0,'City of Lost Souls','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true);
INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (4,0,'Pandemonium','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true);
INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (5,0,'Cinder','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','CIENCIA_FICCION',1000, true);

INSERT INTO users (username,password,enabled,email) VALUES ('KyleConway','$2y$10$Q4zXt8COaMdM07hnNRu4n.084uQMoCOHFV9pAn/fcHzksA/eolnFe',TRUE,'non@enim.net');
INSERT INTO writers (version, description, name, sur_name, photo, username) VALUES (0,'Aficionado a la escritura desde que era pequeños','Libby','Vaughan','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU','KyleConway');
INSERT INTO authorities (username, authority) VALUES ('KyleConway','writer');

INSERT INTO stories (id, version, title, body, genre, storylength) VALUES (6,0,'On Dublin Street','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','FICCION',1000);
INSERT INTO stories (id, version, title, body, genre, storylength) VALUES (7,0,'Bitterblue','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','FICCION',1000);
INSERT INTO stories (id, version, title, body, genre, storylength) VALUES (8,0,'Spell Bound','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','FICCION',1000);

INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (1,1,1);
INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (2,2,1);
INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (3,3,1);
INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (4,4,1);
INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (5,5,1);
INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (6,6,2);
INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (7,7,2);
INSERT INTO rel_story_writers (id, story_id, writer_id) VALUES (8,8,2);