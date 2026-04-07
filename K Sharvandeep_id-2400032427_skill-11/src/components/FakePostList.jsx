
import React, { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [userId, setUserId] = useState("");

  const fetchData = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => {
        setPosts(res.data.posts);
        setFiltered(res.data.posts);
      });
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleFilter = (e) => {
    const value = e.target.value;
    setUserId(value);
    if (value === "") {
      setFiltered(posts);
    } else {
      setFiltered(posts.filter(p => p.userId == value));
    }
  };

  return (
    <div>
      <h2>Fake Posts</h2>

      <select onChange={handleFilter}>
        <option value="">All</option>
        {[...new Set(posts.map(p => p.userId))].map(id => (
          <option key={id} value={id}>User {id}</option>
        ))}
      </select>

      <button onClick={fetchData}>Refresh</button>

      {filtered.map(post => (
        <div key={post.id}>
          <h4>{post.title}</h4>
          <p>{post.body}</p>
        </div>
      ))}
    </div>
  );
}

export default FakePostList;
