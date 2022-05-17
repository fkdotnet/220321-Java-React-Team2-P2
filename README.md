# 220321-Java-React-Team2-P2
team 2 P2 Java React Hibernate


We got this thing guys!!!

## Spring Security Implementation
Our API is now secured via JWT Json Web Token Encryption, on running the application Spring Security will generate 3 boilerplate tables, User, User_Roles, and ROLES. I have defined these roles in an ENUM called ROLES_ENUM

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
this adds a note created above to the specified User Table.

## Note Object Deletion
http://localhost:8080/users/{userid}/notes/{noteid}
A delete request sent with the requested variables, drops the note object from the table

## Note Update



