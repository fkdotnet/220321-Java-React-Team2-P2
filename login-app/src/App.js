import React, { useState, useEffect, useRef } from 'react';
import { BrowserRouter, Switch, Route, NavLink } from 'react-router-dom';
import axios from 'axios';
import Account from "./components/Account";
import Login from './Login';
import infoList from "./infoList";
import Dashboard from './Dashboard';
import CreateArea from "./components/CreateArea";
import PrivateRoute from './Utils/PrivateRoute';
import PublicRoute from './Utils/PublicRoute';
import Home from './Home';
import Profile from "./components/Profile";
import Note from "./components/Note";
import { getToken, removeUserSession, setUserSession } from './Utils/Common';
import apiClient from './http-common';
import userProfile from './userProfile'
import Notes from './pages/Notes';
import EditNote from './pages/EditNote';
import CreateNote from './pages/CreateNote';

function App() {


const [profile,setProfile] = useState(null);
const [getResult, setGetResult] = useState(null);

const [notes, setNotes] = useState([]);









  function addNote(newNote) {
    setNotes(prevNotes => {
      return [...prevNotes, newNote];
    });
  }
// => as function to shorten my code
  function deleteNote(id) {
    setNotes(prevNotes => {
      return prevNotes.filter((noteItem, index) => {
        return index !== id;
      });
    });
  }



  const [authLoading, setAuthLoading] = useState(true);

  useEffect(() => {
    const token = getToken();
  
    const fetchUser = async () =>{
    try {const res = await apiClient.get("/users/"+localStorage.getItem("user_id"),
    {headers: { "Authorization" : localStorage.getItem("TokenHeader")}})
    console.log(res.data);
    setProfile(res.data);
  }catch(err){

  }
}
if (!token) {
  return;
  
}else(fetchUser())
    
  }, []);

  

  return (
    <div className="App">
      <BrowserRouter>
        <div>
          <div className="header">
          <NavLink exact activeClassName="active" to="/">Home</NavLink>

            <NavLink activeClassName="active" to="/login">Login</NavLink>
            <NavLink activeClassName="active" to="/Dashboard">Logout</NavLink>
            <NavLink activeClassName="active" to="/Note">Add note</NavLink>
            <NavLink activeClassName="active" to="/account">User Info</NavLink>
            <NavLink activeClassName="active" to="/notes/create">create</NavLink>
            <NavLink activeClassName="active" to="/notes">User Info</NavLink>



          </div>
          <div className="content">
            <Switch>
              
            <Route exact path="/" component={Home} />

            <PrivateRoute path="/Account">
              <div>
                
              </div>              
              </PrivateRoute>
              <PublicRoute path="/login" component={Login} />
              <PrivateRoute path="/dashboard" component={Dashboard} />
                <PrivateRoute  path="/Note" component={Note}>

                    
                    <div>
                    
                    </div>
                  </PrivateRoute>

                  <Route exact path="/" component={Notes} />
                <Route exact path="/notes/:id/edit" component={EditNote} />
                <Route exact path="/notes/create" component={CreateNote} />
            </Switch>
          </div>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
