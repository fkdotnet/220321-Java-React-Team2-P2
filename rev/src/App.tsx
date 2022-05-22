import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import './App.css';
import { Home } from './components/Home/Home';
import { Login } from './components/Login/Login';
import { Register } from './components/Register/Register';
import Weather  from './components/Weather/weather.js'

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Login/>}/>
        </Routes>
        <Routes>
          <Route path="/register" element={<Register/>}/>
        </Routes>
        <Routes>
          <Route path="/home" element={<Home/>}/>
        </Routes>
        <Routes>
          <Route path="/weather" element={<Weather/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
