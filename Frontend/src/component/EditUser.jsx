import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export  function EditUser() {

  let navigate = useNavigate();

  const { id } = useParams();

  const [user, setUser] = useState({
    fname: "",
    username: "",
  });

  const { fname, lname ,email } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/user/${id}`, user);
    navigate("/EditUser");
  };

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/customers/${id}`);
    setUser(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit User</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                First Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="fname"
                value={fname}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                Last name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your username"
                name="lname"
                value={lname}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                E-mail
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your e-mail address"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/Admin">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}