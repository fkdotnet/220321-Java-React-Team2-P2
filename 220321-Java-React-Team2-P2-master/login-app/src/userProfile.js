import React from "react";
import apiClient from './http-common';

const formatResponse = (res) => {
    return JSON.stringify(res, null, 2);
  };
  
  
  
  
  async function getUserData(){
    
      const res = await apiClient.get("/users/"+localStorage.getItem("user_id"),
      {headers: { "Authorization" : localStorage.getItem("TokenHeader")}
    });
    const result = {
      status: res.status,
      headers: res.headers,
      data: res.data 
    };
  
    const res7 = formatResponse(result);
  }
  