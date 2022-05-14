CREATE TABLE dark_mode.users (
    user_id serial PRIMARY key,
    username varchar(50) NULL,
    passwrd varchar(50) NULL,
    first_name varchar(100) NULL,
    last_name varchar(100) NULL,
    email varchar(150) NULL);


INSERT INTO users  (username, passwrd, first_name, last_name, email)
 values('','','','',''),
       ('','','','',''),
       ('','','','',''),
       ('','','','',''),
       ('','','','','')





CREATE TABLE dark_mode.notes (
    note_id serial PRIMARY key,
    title varchar(50) NULL,
    note_object varchar(50) NULL,
    date_created varchar(100) NULL,
    "user" int REFERENCES users (user_id)
    );


INSERT INTO users  (tile, note_object, date_created, "user")
 values('','','','',''),
       ('','','','',''),
       ('','','','',''),
       ('','','','',''),
       ('','','','','')