
--INSERT INTO users(username,password,enabled) VALUES ('adminTest','adminTest',TRUE), ('ivanlot','ivanlot',TRUE), ('user','user',TRUE), ('artist','artist',TRUE);

INSERT INTO users(username,password,enabled) VALUES ('adminTest','$2a$10$xpgy46/5c/UsKgD1/UQNWuze5c//nH/d5ff8cigK0saMtoznD8x0K',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('ivanlot','$2a$10$lD0WmxowSo/xSsd6rPwPQevaIu7G4UhtocWiQrLwd9bOvMF5N40Ay',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('user','$2a$10$2B0fDl/04SUIhlcpDoLHOunMq4JPIzv2AqRM6DKrjWVRL.8EQUSBe',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('artist','$2a$10$lAuC/wtbSo22eMCtSgDgxe/N3q2QnNjYxIhvTKzudFhtH1pICCzZe',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu',TRUE);
INSERT INTO authorities(username,authority) VALUES ('admin','admin');

INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('1','Christopher','Nolan','12345678D','Productor exitoso y feliz con ganas de trabajar con un equipo de trabajo apasionado por el cine de terror', 'adminTest');
INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('2','Woody','Allen','19876543W','Productor con larga experiencia en películas de ciencia ficción', 'ivanlot');
INSERT INTO producers(version,name,sur_Name,nif, description, username) VALUES ('3','Mel','Gibson','34587666Y ','Productora con ganas de realizar un cortometraje acerca del covid y su repercusión en la vida de las personas','user');

INSERT INTO messages(issue,body,date,emisor_id,receptor_id) VALUES ('Bienvenido','He escuchado que acabas de entrar en la pagina, que tal te va?',TO_DATE('28/03/2021', 'DD/MM/YYYY'),'user', 'ivanlot');
INSERT INTO messages(issue,body,date,emisor_id,receptor_id) VALUES ('Me encanta esto','Bastante bien, me esta encantando como funciona, cuanto tiempo llevas aqui?',TO_DATE('29/03/2021', 'DD/MM/YYYY'),'ivanlot', 'user');
INSERT INTO messages(issue,body,date,emisor_id,receptor_id) VALUES ('Pues si','Llevo aqui apenas 2 semanas, pero es como si llevara toda la vida de lo facil de usar que es',TO_DATE('30/03/2021', 'DD/MM/YYYY'),'user', 'ivanlot');