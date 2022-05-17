# 220321-Java-React-Team2-P2
team 2 P2 Java React Hibernate



## Spring Security Implementation
Our API is now secured via JWT Json Web Token Encryption, on running the application Spring Security will generate 3 boilerplate tables, User, User_Roles, and ROLES. I have defined these roles in an ENUM called ROLES_ENUM


The first thing you should do is register a user with a post request to:

http://hostname:8080/api/auth/signup

with the user details as such in the body 
{
"username":"user",
"password":"password",
"email":"email",
"role":["admin","user"]
}
this will create a user account with a Hashed Password -- do NOT add the user in plain text via DBeaver as it will not read the login info




Login is achieved by sending a post request to http://hostname:8080/api/auth/signin

{
"username":"user",
"password":"password"
}

response will be user info + JSON Web Token. I will likely from here tie in the notes to another table with the same user and pw. 

Registration is a post to signup with the details.
All of the methods tagged @Preauthorize require an auth token




## Requests/Handler Addressing

This API has all of the crud methods neccesary for the purposes of the RevNotes app. Here are the endpoints and protocols, along with a description and a sample JSON payload


## Note Object POST Requests
http://localhost:8080/notes
A post with this object will add a note to the TABLE (read on)
                {
                "note_id": 1,
                "note_title": "firstnote",
                "newUserDTO": null,
                "date_created": "05/15/22",
                "noteObject": "this is a note",
                "userID": 1
                }
 Add this note with a USERID, to attatch to a certain user use the OTHER Add post, an empty user ID will throw a Null pointer. This will work fine from within your webclient once we have a user id, but for testing purposes just use an entry on the database in the RevUserTable
 

A POST Request to 
http://localhost:8080/users/{userID}/notes/{noteID}/add
(UserID and NoteID = The id numbers from the RevUser and Notes Table of your choice)
this adds a note created above to the specified User in the Table.

## Note Object Deletion
http://localhost:8080/users/{userid}/notes/{noteid}
A delete request sent with the requested variables, drops the note object from the table

## Note Update
Pass the note in Json format in a PUT request to:
users/{userid}/notes/"
where the users id is in the link (revnotes user id)



## Application Configuration 
Open the project and navigate to source/main/resources and fill out the placeholders below

spring.main.banner-mode=CONSOLE

logging.level.org.springframework=ERROR

spring.datasource.initialization-mode=always

spring.datasource.platform=postgres

spring.datasource.url=jdbc:postgresql://localhost:5432/{YOUR_DBs_NAME}

spring.datasource.username={YOURPOSTGREUSERNAME}

spring.datasource.password={YOURPOSTGREPASSWORD}

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true

spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto= update

darkmode.app.jwtSecret= teamDarkmode

darkmode.app.jwtExpirationMs= 86400000



