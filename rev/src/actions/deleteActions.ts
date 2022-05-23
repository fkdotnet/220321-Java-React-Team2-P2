import { NOTE_DEL } from "./actionTypes";

//This is the file where our actual business logic will occur (like calls to an API)

import axios from "axios";
//There will be functionality here that use or change our User state object


export const deleteNote = (authHeader: string, userId: number, curID: number) => async (dispatch:any) => {
    try {

        const response = await axios.delete('http://localhost:8080/notes/'+  + String(curID), { headers: {Authorization: authHeader} });

        if(response.status === 200) { //if the login was successful...
            
            console.log(response) //to see the data coming back

            return true
        }

    } catch (e) {
        console.log("DELETE FAILED!")
        return false
    }

    

}




