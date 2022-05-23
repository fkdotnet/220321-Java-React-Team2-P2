import React, { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux";
import { Navigate, useNavigate } from "react-router-dom";
import { notes } from "../../actions/NotesActions";
import { INote, IUserData } from "../../store/types";
import { saveNote } from "../../actions/SaveActions";
import { LOGIN_USER, NOTE_SAVE } from "../../actions/actionTypes";
import { deleteNote } from "../../actions/deleteActions";
import "./Home.css"

interface INoteItemProps {
    noteItem: INote;
    itemSelect: (noteItem: INote) => void;
}

const Note = ({noteItem, itemSelect}: INoteItemProps) => {
    const onItemSelect = () => {
        itemSelect(noteItem)
    }
    return (
        <div className="note-card-container" onClick = {onItemSelect}>
            <div className="note-card-title">
                {noteItem.title}
            </div>
            <div className="note-card-content"> 
                {noteItem.content}
            </div>
        </div>
    )
}




export const Home: React.FC<any> = () => {

    //we need useSelector to access the store
    //we set it so that it can take <any state, and access any store>
    //our state object is set to change to whatever (state is in the store) 
    const appState = useSelector<any, any>((state) => state)

    //we'll use this object to switch components whenever appropriate
    //this is what lets us navigate through the application through button clicks, etc.
    const navigate = useNavigate();

    //we need useDispatch to DISPATCH information to our Action (which dispatches to the store/reducers)
    const dispatch = useDispatch();

    const [showNote, setShowNote] = useState(false)
    const [curID, setCurID] = useState(0)
    const [title, setTitle] = useState('')
    const [content, setContent] = useState('')
    const [completed,setCompleted] = useState(false)

    const handleChange = (e:any) => {
        if(e.target.name === "title"){ 
            setTitle(e.target.value) //set title to be the value that was inserted
        } else {
            setContent(e.target.value) //otherwise, set the content with that value.
        }
    }

    const toggleNote = () => {
        setShowNote(!showNote)
        setCurID(0)
        setTitle('')
        setContent('')
    }

    const itemSelected = (item: INote) => {
        setShowNote(true)
        setCurID(item.id)
        setTitle(item.title)
        setContent(item.content)
    }
   

    const onSave = async() => {
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        let todayString = mm + '/' + dd + '/' + yyyy;
        console.log(todayString)

        let userJson: string | null = localStorage.getItem('user')? localStorage.getItem('user'): null
        let userData: IUserData = userJson? JSON.parse(userJson) : null
        // console.log("userData: ", userData)
        if(!userData) navigate("/");

        const authHeader = userData.tokenType + ' ' + userData.accessToken

        const saveResult = await dispatch(saveNote({
            note_title: title,
            noteObject: content,
            date_created: todayString
        }, authHeader, userData.id, curID) as any)

        if(saveResult) {
            await timeout(500)
            setShowNote(false)
            dispatch(notes(authHeader, userData.id) as any)
            
            
            
        }
    }
    const onDelete = async () => {
        let userJson: string | null = localStorage.getItem('user')? localStorage.getItem('user'): null
        let userData: IUserData = userJson? JSON.parse(userJson) : null
        // console.log("userData: ", userData)
        if(!userData) navigate("/");
    
        const authHeader = userData.tokenType + ' ' + userData.accessToken
    
        const deleteResult =  await dispatch(deleteNote(authHeader, userData.id, curID) as any)
    console.log(deleteResult)
        if(deleteResult) {
            await timeout(500)
            setShowNote(false)
            dispatch(notes(authHeader, userData.id) as any)
            

        }
    }
    function timeout(delay: number) {
        return new Promise( res => setTimeout(res, delay) );
    }
      

    const logout = () => {
        localStorage.removeItem('user')
        dispatch({
            type: LOGIN_USER,
            payload: {
                id: 0,
                username: '',
                password: ''
            }
        })
        navigate("/")
    }

    useEffect(() => {
        setCompleted(false)
        let userJson: string | null = localStorage.getItem('user')? localStorage.getItem('user'): null
        let userData: IUserData = userJson? JSON.parse(userJson) : null
        console.log("userData: ", userData)
        if(!userData) {navigate("/"); return;}
        if(completed){
            window.location.reload()
        }
        const authHeader = userData.tokenType + ' ' + userData.accessToken
        console.log(authHeader)
        
        // load notes in initial
        dispatch(notes(authHeader, userData.id) as any)
    }, [])

    return(
        <>
            <div className="nav-container">
            

                <div className="nav-logo"> RevNotes</div>
                
                <div className="nav-button-logout" onClick={() => logout()} >
                    Logout
                </div>  
                <div className="nav-button" onClick={() => toggleNote()} >
                { showNote ? 'Cancel' :  '+ Note' }
                </div>  
                <div className="nav-button" onClick={()=>navigate("/weather")}>
                Weather
                </div>
                <div className="nav-button" onClick={()=>window.location.reload()}>
                    Notes
                </div>
            </div>
            <br />
            {showNote? 
                <div className="note-container">
                    <h2>Edit Note</h2>
                    <form
                    className="note-form"
                    >
                    <div className="note-title">
                        <input
                        className="note-title-input"
                        type="text"
                        placeholder="Note Title..."
                        defaultValue={title}  
                        name="title"
                        onChange={handleChange}
                        />
                    </div>
                    <div className="note-textarea-container">
                        <textarea
                        className="note-textarea"
                        placeholder="Type Here..."
                        defaultValue={content}
                        name="content"
                        onChange={handleChange}
                        />
                    </div>
                    <div className="note-button" onClick={onSave} >Save</div>
                    <div className="note-button" onClick={onDelete}> Delete note</div>
                    </form>
                </div>
            :                
            <div className="list-container"> 
                {
                    appState.notes.initialState ? appState.notes.initialState.map((item: any) => (
                        <Note key={item.id} noteItem={item} itemSelect={itemSelected} />
                    )) : null
                }                   
            </div>
            } 
            
        </>
    );
} 