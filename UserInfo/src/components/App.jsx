import React from "react";
import Account from "./Account";
import infoList from "../infoList";

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

function App() {
  return (
    <div>
        <dl className="dictionary">{infoList.map(createAccount)}</dl>



    </div>
  );
}

export default App;
