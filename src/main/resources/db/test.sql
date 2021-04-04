INSERT INTO users(username,password,enabled) VALUES ('userTest1','userTest1',TRUE);
INSERT INTO users(username,password,enabled) VALUES ('userTest2','userTest2',TRUE);

INSERT INTO messages(version,issue,body,messageDate,emisor_id,receptor_id) VALUES (0,'Test Issue 1','Test Body 1',TO_DATE('28/03/2021', 'DD/MM/YYYY'),'userTest1', 'userTest2');