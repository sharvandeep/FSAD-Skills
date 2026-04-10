import React, { useState } from "react";
import axios from "axios";

export default function Register() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const register = async () => {
    await axios.post("http://localhost:8080/api/register", {
      username,
      password
    });
    window.location.href = "/";
  };

  return (
    <div>
      <h2>Register</h2>
      <input onChange={e => setUsername(e.target.value)} placeholder="Username" />
      <input type="password" onChange={e => setPassword(e.target.value)} placeholder="Password" />
      <button onClick={register}>Register</button>
    </div>
  );
}