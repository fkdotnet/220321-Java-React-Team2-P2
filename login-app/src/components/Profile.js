import React from "react";
import{Redirect} from "react-router-dom";

function Profile({authorized}){
    if(!authorized){
        return<Redirect to="/login" />;

    }
    return <div>If u are here, You are allowed to be here!</div>;

}
export default Profile;
