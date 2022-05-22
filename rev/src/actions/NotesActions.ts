//This is the file where our actual business logic will occur (like calls to an API)

import axios from "axios";
import { INote } from "../store/types"
import { NOTES_DATA } from "./actionTypes";

//There will be functionality here that use or change our User state object

// get all note object array
export const notes = (authHeader: string, userId: number) => async (dispatch:any) => {
    let notes: Array<INote> = []
    try {
        const response = await axios.get('http://localhost:8080/notes/byUser/' + String(userId), { headers: {Authorization: authHeader} });

        if(response.status === 200) { //if the login was successful...
            
            console.log(response) //to see the data coming back

            //populate our notes variable based on the data sent back from the server
            //this is the payload of new data we're going to dispatch to the store
            response.data.map((item: any) => {
                let note: INote = {
                    id: item.note_id,
                    title: item.note_title,
                    content: item.noteObject
                }
                notes.push(note)
            })

            //now we actually DISPATCH (send) this data to the store and reducers 
            //see UserReducer, see store.ts
            //notice in the reducers, this is the type of data we need for the Action object
            return dispatch({ 
                type: NOTES_DATA,
                payload: notes
            })

        }
 
    } catch (e) {
        console.log("GET NOTES FAILED!")
    }

}