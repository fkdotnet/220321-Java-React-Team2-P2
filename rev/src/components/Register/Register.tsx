import React, { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux"
import { useNavigate } from "react-router-dom"
import { registerUser } from "../../actions/RegisterActions"

import "./Register.css"

export const Register: React.FC<any> = () => {

    //this is how we access the state in the store. The data in the universal data file.
    const appState = useSelector<any, any>((state) => state);

    //we need this object to actually dispatch data to our store
    const dispatch = useDispatch();

    //useState hooks to declare a state object, a mutator (which changed state), and a default value
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');
    let [email, setEmail] = useState('');

    //we'll use this object to switch components whenever appropriate
    //this is what lets us navigate through the application through button clicks, etc.
    const navigate = useNavigate();

    //when user updates the username/password field, this function is called
    //when user updates the values, username OR password get updated as well
    //this is how we can send a username/password object to the loginUser Action
    const handleChange = (e:any) => {
        if(e.target.name === "username"){ //if the input is name=username...
            setUsername(e.target.value) //set username to be the value that was inserted
            console.log(username) //to show useState working
        } else if(e.target.name === "password") {
            setPassword(e.target.value) //otherwise, set the password with that value.
        } else {
            setEmail(e.target.value)
        }
    }

    const register = async () => {
        await dispatch(
            registerUser({username, password, email, role: ["user"]}) as any
            //these are the states that were changed with handleChange
            //we need "as any" to make it so that the return type can be any type
        )
    }

    const cancel = () => {
        navigate("/");
    }

    //useEffect hook that runs when appState changes
    //based on whether the user successfully logged in, change the page or do nothing
    useEffect(() => {
        if(appState.register.id > 0){
            alert("Registered Successfully!")
            navigate("/"); //thanks to Routing in the App.tsx, this will switch the component.
        }
    }, [appState])


    return(
        <div className="login">

            <div className="text-container">
                <h1>Register!</h1>
                <h3>Input register information</h3>

                <div className="input-container">
                    <input type="text" name="username" placeholder="username" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="text" name="email" placeholder="Email" onChange={handleChange}/>
                </div>

                <button className="login-button" onClick={register}>Register</button>
                <button className="cancel-button" onClick={cancel}>Cancel</button>
            </div>

        </div>
    )

} 