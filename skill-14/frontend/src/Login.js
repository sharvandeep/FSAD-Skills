import React, { useState } from "react";
import axios from "axios";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const login = async () => {
    const res = await axios.post("http://localhost:8080/api/login", {
      username,
      password
    });

    if (res.data !== "Invalid") {
      localStorage.setItem("user", res.data);
      window.location.href = "/home";
    } else {
      alert("Invalid credentials");
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input onChange={e => setUsername(e.target.value)} placeholder="Username" />
      <input type="password" onChange={e => setPassword(e.target.value)} placeholder="Password" />
      <button onClick={login}>Login</button>
      <br />
      <a href="/register">Register</a>
    </div>
  );
}