import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList() {
  const [students, setStudents] = useState([]);

  const fetchData = () => {
    axios.get("/students")
      .then(res => setStudents(res.data));
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <h2>Students</h2>
      {students.map(s => (
        <div key={s.id}>
          {s.name} - {s.email} - {s.course}
        </div>
      ))}
    </div>
  );
}

export default StudentList;
