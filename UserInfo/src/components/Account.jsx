import React from "react";



function Account(props) {
  return (
    

      <div className="card">
      <div className="top">
        <h2 className="name">{props.fname}{" "}{props.lname}</h2>
        <img align= "right" className="circle-img" src={props.img} alt="avatar_img" />

      </div>
      
      <div className="bottom">


       <p><b>Username</b> {props.uname}</p>
       <p><b>Email : </b>{props.email}</p>
  
      </div>
    </div>





  );
}

export default Account;
