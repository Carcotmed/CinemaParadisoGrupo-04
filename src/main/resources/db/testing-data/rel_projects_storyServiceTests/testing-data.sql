
INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (1,0,'First Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (2,0,'Second Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO projects (id,version,title, genre, description, pro, photo,my_admin,is_sponsored) VALUES (3,0,'Third Project','ACCION','Creando contenido desde hace 17 años, buscamos nuevos miembros',true,'https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=','JarrodHuffman',true);

INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (1,0,'Story 1','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true);

INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (2,0,'Story 2','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true);

INSERT INTO stories (id, version, title, body, genre, storylength, is_sponsored) VALUES (3,0,'Story 3','En esta historia el protagonista decide abandonar su hogar y explorar el mundo','ACCION',1000, true);

INSERT INTO rel_projects_story (id, project_id, story_id) VALUES (1,1,1);

INSERT INTO rel_projects_story (id, project_id, story_id) VALUES (2,2,2);

INSERT INTO rel_projects_story (id, project_id, story_id) VALUES (3,3,1);
INSERT INTO rel_projects_story (id, project_id, story_id) VALUES (4,1,3);


