import React from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {
  return (
    <div>
      <h1>Student Management</h1>
      <AddStudent />
      <StudentList />
    </div>
  );
}

export default App;
