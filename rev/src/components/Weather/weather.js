import React, { useState } from 'react';
import'./weather.css';
import { Navigate, useNavigate } from "react-router-dom";
const api = {
  key: "012442ba1a1968c14105c7d9fbd96faa",
  base: "https://api.openweathermap.org/data/2.5/"
}

function Weather() {
  const [query, setQuery] = useState('');
  const [weather, setWeather] = useState({});
  const navigate = useNavigate();


  const search = evt => {
    if (evt.key === "Enter") {
      fetch(`${api.base}weather?q=${query}&units=metric&APPID=${api.key}`)
        .then(res => res.json())
        .then(result => {
          setWeather(result);
          setQuery('');
          console.log(result);
        });
    }
  }

  const dateBuilder = (d) => {
    let months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

    let day = days[d.getDay()];
    let date = d.getDate();
    let month = months[d.getMonth()];
    let year = d.getFullYear();

    return `${day} ${date} ${month} ${year}`
  }

  return (
    <div ClassName="wpage">
    <div className={(typeof weather.main != "undefined") ? (((((weather.main.temp)*9/5)+32) > 60) ? 'app warm' : 'app') : 'app'}>
      <main>
        <div className="search-box">
          <input 
            type="text"
            className="search-bar"
            placeholder="Search..."
            onChange={e => setQuery(e.target.value)}
            value={query}
            onKeyPress={search}
          />
        </div>
        {(typeof weather.main != "undefined") ? (
        <div>
          <div className="location-box">
            <div className="location">{weather.name}, {weather.sys.country}</div>
            <div className="date">{dateBuilder(new Date())}</div>
          </div>
          <div className="weather-box">
            <div className="temp">
              {Math.round(((weather.main.temp)*9/5)+32)}°F
            </div>
            <div className="weather">{weather.weather[0].main}</div>
          </div>
          <div className="hometext" onClick={()=> navigate("/home")}> Click here to go back..</div>
        </div>
        ) : ('')}
          
      </main>

    </div>
    </div>
  );
}
export default  Weather;