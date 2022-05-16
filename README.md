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
