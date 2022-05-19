import React, { useState, useEffect } from 'react';
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


import Notes from './pages/Notes';
import EditNote from './pages/EditNote';
import CreateNote from './pages/CreateNote';

function App() {


  



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

  function createAccount(infoList) {
    return (
      <Account
        key={infoList.id}
        img={infoList.imgURL}
        uname={infoList.username}
        fname={infoList.first_name}
        lname={infoList.last_name}
        email={infoList.email}
      />
      
    );
  }


  const [authLoading, setAuthLoading] = useState(true);

  useEffect(() => {
    const token = getToken();
    if (!token) {
      return;
    }

    axios.get(`"http://localhost:8080/api/auth/signin"/verifyToken?token=${token}`).then(response => {
      setUserSession(response.data.accessToken, response.data.username);
      setAuthLoading(false);
    }).catch(error => {
      removeUserSession();
      setAuthLoading(false);
    });
  }, []);

  if (authLoading && getToken()) {
    return <div className="content">Checking Authentication...</div>
  }

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
                  <dl className="dictionary">{infoList.map(createAccount)}</dl>
              </div>
              </PrivateRoute>
              <PublicRoute path="/login" component={Login} />
              <PrivateRoute path="/dashboard" component={Dashboard} />
                <PrivateRoute  path="/Note" component={Note}>

                    
                    <div>
                    <CreateArea onAdd={addNote} />
                  {notes.map((noteItem, index) => {
                    return (
                      <Note
                        key={index}
                        id={index}
                        title={noteItem.title}
                        content={noteItem.content}
                        onDelete={deleteNote}
                      />
                    );
                  })} 
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
