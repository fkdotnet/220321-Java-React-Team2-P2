import { NOTE_SAVE } from "./actionTypes";
import {updateNote} from "./updateActions"

//This is the file where our actual business logic will occur (like calls to an API)

import axios from "axios";
//There will be functionality here that use or change our User state object

//interface that models the note, we'll send in our POST request
interface NoteSave {
    note_title: string,
    noteObject: string,
    date_created: string,
}

export const saveNote = (noteData:NoteSave, authHeader: string, userId: number, curID: number) => async (dispatch:any) => {
    if(curID === 0) {
        let newNoteId
    
        try {
    
            const response = await axios.post('http://localhost:8080/notes', noteData, { headers: {Authorization: authHeader} });
    
            if(response.status === 200) { //if the login was successful...
                
                console.log(response) //to see the data coming back
    
                newNoteId = response.data.note_id
    
                // return true
            }
    
        } catch (e) {
            console.log("SAVE FAILED!")
            return false
        }
    
        try {

            console.log(authHeader)
    
            const response = await axios.post('http://localhost:8080/users/' + String(userId) + '/notes/' + String(newNoteId) + '/add', noteData, { headers: {Authorization: authHeader} });
    
            if(response.status === 200) { //if the login was successful...
                
                console.log(response) //to see the data coming back
    
                newNoteId = response.data.note_id
    
                return true
            }
    
        } catch (e) {
            console.log("SAVE FAILED!")
            return false
        }
    } else {
        try {

            console.log(noteData)
            console.log(authHeader)
    
            const response = await axios.put('http://localhost:8080/notes/' + String(curID), noteData, { headers: {Authorization: authHeader, 'content-type': 'application/x-www-form-urlencoded'} });
    
            if(response.status === 200) { //if the login was successful...
                
                console.log(response) //to see the data coming back
    
                return true
            }
    
        } catch (e) {
            console.log("UPDATE FAILED!")
            return false
        }
    }

   
}