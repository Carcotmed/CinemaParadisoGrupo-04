INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser1','does not matter',TRUE,'autoCreatedUser1@cinemaparadiso.com');
INSERT INTO users(username,password,enabled,email) VALUES ('autoCreatedTestUser2','does not matter',TRUE,'autoCreatedUser2@cinemaparadiso.com');

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (1,0,'Test Issue 1','Test Body 1',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser1','autoCreatedTestUser2',false);
INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (2,0,'Test Issue 2','Test Body 2',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser1','autoCreatedTestUser2',false);

INSERT INTO messages (id,version,issue, body, messagedate, emisor_id, receptor_id,is_request) VALUES (3,0,'Test Issue To Delete','Test Body To Delete',TO_DATE('2021/04/10', 'YYYY/MM/DD'),'autoCreatedTestUser1','autoCreatedTestUser2',false);
