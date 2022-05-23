//This is the file where our actual business logic will occur (like calls to an API)

import axios from "axios";
import { IUser } from "../store/types"
import { LOGIN_USER } from "./actionTypes";

//There will be functionality here that use or change our User state object

//interface that models the user's login credentials, we'll send in our POST request
interface UserLogin {
    username: string,
    password: string
}

//loginUser functionality
//we send in an object of type UserLogin, since that's what we're sending in our POST
//dispatch:any? this means we can send (or dispatch) any object to the store from this function
export const loginUser = (loginCreds:UserLogin) => async (dispatch:any) => {

    //create an empty object of type IUser - this will get filled on successful login
    let loggedInUser: IUser;

    try {

        const response = await axios.post('http://localhost:8080/api/auth/signin', loginCreds);

        console.log(response.status)

        if(response.status === 200) { //if the login was successful...
            localStorage.setItem("user", JSON.stringify(response.data));
            
            console.log(response) //to see the data coming back

            //populate our loggedInUser variable based on the data sent back from the server
            //this is the payload of new data we're going to dispatch to the store
            loggedInUser = {
                id: response.data.id,
                username: response.data.username,
                password: response.data.password
            }

            //now we actually DISPATCH (send) this data to the store and reducers 
            //see UserReducer, see store.ts
            //notice in the reducers, this is the type of data we need for the Action object
            return dispatch({
                type: LOGIN_USER,
                payload: loggedInUser
            })


        }
        

    } catch (e) {
        console.log("LOGIN FAILED!")
    }

}