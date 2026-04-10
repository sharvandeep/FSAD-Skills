import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Profile() {
  const [data, setData] = useState({});
  const user = localStorage.getItem("user");

  useEffect(() => {
    if (!user) {
      window.location.href = "/";
    } else {
      axios.get(`http://localhost:8080/api/profile/${user}`)
        .then(res => setData(res.data));
    }
  }, []);

  return (
    <div>
      <h2>Profile</h2>
      <p>Username: {data.username}</p>
      <p>Email: {data.email}</p>
    </div>
  );
}