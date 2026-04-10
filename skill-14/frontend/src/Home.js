export default function Home() {
  const user = localStorage.getItem("user");

  if (!user) {
    window.location.href = "/";
  }

  return (
    <div>
      <h2>Welcome {user}</h2>
      <a href="/profile">Go to Profile</a>
      <br />
      <button onClick={() => {
        localStorage.removeItem("user");
        window.location.href = "/";
      }}>
        Logout
      </button>
    </div>
  );
}