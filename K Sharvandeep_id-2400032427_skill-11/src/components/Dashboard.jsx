
import React from "react";
import { Link } from "react-router-dom";

function Dashboard() {
  return (
    <div>
      <h1>Dashboard</h1>
      <h2>2400032309-Abhiram</h2>
      <Link to="/local">Local Users</Link><br />
      <Link to="/users">Users API</Link><br />
      <Link to="/posts">Fake Posts</Link>
    </div>
  );
}

export default Dashboard;
