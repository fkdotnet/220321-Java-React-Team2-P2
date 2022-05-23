import axios from "axios";
import { INote } from "../store/types"
import { NOTES_DATA } from "./actionTypes";





interface NoteSave {
    note_title: string,
    noteObject: string,
    date_created: string,
}



export const updateNote = (noteData:NoteSave, authHeader: string, userId: number, curID: number) => async (dispatch:any) => {
    if(curID === 0) {
        let newNoteId
    
        try {
    
            const response = await axios.put('http://localhost:8080/notes'+curID, noteData, { headers: {Authorization: authHeader} });
    
            if(response.status === 200) { //if the login was successful...
                
                console.log(response) //to see the data coming back
    
                newNoteId = response.data.note_id
    
                // return true
            }
    
        } catch (e) {
            console.log("UPDATE FAILED!")
            return false
        }
    }

   
}