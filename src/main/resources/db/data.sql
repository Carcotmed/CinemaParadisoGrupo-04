CREATE TABLE users(
	username varchar_ignorecase(255) NOT NULL PRIMARY KEY,
	password varchar_ignorecase(255) NOT NULL,
	enabled BOOLEAN NOT NULL
);


INSERT INTO users(username,password,enabled) VALUES ('admin','admin',TRUE),
('adminTest','adminTest',TRUE),
('ivanlot','ivanlot',TRUE),
('user','user',TRUE),
('artist','artist',TRUE);

--INSERT INTO messages(id,version,issue,body,messagedate,emisor_id,receptor_id) VALUES (1,1,'Bienvenido','He escuchado que acabas de entrar en la pagina, que tal te va?',TO_DATE('28/03/2021', 'DD/MM/YYYY'),'user', 'ivanlot');
--INSERT INTO messages(id,version,issue,body,messagedate,emisor_id,receptor_id) VALUES (2,2,'Me encanta esto','Bastante bien, me esta encantando como funciona, cuanto tiempo llevas aqui?',TO_DATE('29/03/2021', 'DD/MM/YYYY'),'ivanlot', 'user');
--INSERT INTO messages(id,version,issue,body,messagedate,emisor_id,receptor_id) VALUES (3,3,'Pues si','Llevo aqui apenas 2 semanas, pero es como si llevara toda la vida de lo facil de usar que es',TO_DATE('30/03/2021', 'DD/MM/YYYY'),'user', 'ivanlot');

--INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
--INSERT INTO authorities(username,authority) VALUES ('admin','admin');