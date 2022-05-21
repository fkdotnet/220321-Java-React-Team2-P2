//This is the file where our actual business logic will occur (like calls to an API)

import axios from "axios";
import { IRegister } from "../store/types"
import { REGISTER_USER } from "./actionTypes";

//There will be functionality here that use or change our User state object

//interface that models the user's login credentials, we'll send in our POST request
interface UserRegister {
    username: string,
    password: string,
    email: string,
    role: string[],
}

//registerUser functionality
//we send in an object of type UserLogin, since that's what we're sending in our POST
//dispatch:any? this means we can send (or dispatch) any object to the store from this function
export const registerUser = (registerData:UserRegister) => async (dispatch:any) => {
    
    let registeredInUser: IRegister;

    try {

        const response = await axios.post('http://localhost:8080/api/auth/signup/', registerData);

        if(response.status === 200) { //if the login was successful...
            
            console.log(response) //to see the data coming back

            //populate our registeredInUser variable based on the data sent back from the server
            //this is the payload of new data we're going to dispatch to the store
            registeredInUser = {
                id: 1,
            }

            //now we actually DISPATCH (send) this data to the store and reducers 
            //see UserReducer, see store.ts
            //notice in the reducers, this is the type of data we need for the Action object

            // alert("Registered successfully!")
            return dispatch({
                type: REGISTER_USER,
                payload: registeredInUser
            })
        }

    } catch (e) {
        console.log("REGISTER FAILED!")
    }

}