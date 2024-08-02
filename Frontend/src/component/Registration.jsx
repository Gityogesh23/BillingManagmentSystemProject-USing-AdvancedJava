import React, { useState } from 'react';
import { Button, Col, Container, Form, Row } from "react-bootstrap";
import axios from 'axios';
import { LinkContainer } from 'react-router-bootstrap';
import { useNavigate } from 'react-router-dom';
import '../component/RegistrationsForm.css'

export function Registration() {

  const navigate = useNavigate();
  const [show, setShow] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);


  const [formData, setFormData] = useState({
    lname: '',
    fname: '',
    gender: '',
    adhar: '',
    address: '',
    email: '',
    phoneNo: '',
    password: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // Replace 'YOUR_BACKEND_API_ENDPOINT' with the actual endpoint where you want to send the registration data
      console.log(formData)
      const response = await axios.post('http://localhost:8080/customer', formData);
      console.log(response.data);

      navigate('/login');
    } catch (error) {
      console.error('Error submitting the form:', error.message);
    }
  };

  return (
    <Container className="container ">
      <div className="bg">
        <style>
          {`
        body {
          background-color: #ffffff; 
        
        }
      `}
        </style>
        <h2
          style={{ marginTop: "10px", textAlign: "center", color: "#265073" }}
        >
          Please fill in all the details to Register
        </h2>

        <hr />
        {/* <Header text="Register Applicant Here"></Header> */}
        <Form onSubmit={handleSubmit}>
          <Row>
            <Col lg={6}>
              <Form.Group className="mb-3">
                <Form.Label className="textbold">First Name</Form.Label>
                <Form.Control
                  type="text"
                  value={isSubmitted ? formData.fname : null}
                  placeholder="Enter Name"
                  onKeyUp={handleChange}
                  name="fname"
                  // style={{ width: '200%', marginRight: '640%' }}
                />

              </Form.Group>
            </Col>
            <Col lg={6}>
              <Form.Group className="mb-3 ">
                <Form.Label className="textbold">Last Name </Form.Label>
                <Form.Control
                  type="text"
                  value={isSubmitted ? formData.lname : null}
                  placeholder="Enter Last Name"
                  onKeyUp={handleChange}
                  name="lname"
                  // style={{ width: '200%', marginRight: '640%' }}
                />
              </Form.Group>
            </Col>
          </Row>
          <Row>
            <Col xl={6}>
              <Form.Label className="textbold">Enter Your Gender
              </Form.Label>
              <Form.Check
                type="radio"
                label="Male"
                name="gender"
                value="male"
                onChange={handleChange}
              />
              <Form.Check
                type="radio"
                label="Female"
                name="gender"
                value="female"
                onChange={handleChange}
              />
            </Col>
            <Col lg={6}>
              <Form.Group className="mb-3">
                <Form.Group className="mb-3">
                  <Form.Label className="textbold">Address </Form.Label>
                  <Form.Control
                    type="text"
                    value={isSubmitted ? formData.address : null}
                    placeholder="Enter Address"
                    onKeyUp={handleChange}
                    name="address"
                  />
                </Form.Group>
              </Form.Group>
            </Col>
          </Row>  
          <Row>
            <Col lg={4}>
              <Form.Group className="mb-3">
                <Form.Group className="mb-3">
                  <Form.Label className="textbold">City </Form.Label>
                  <Form.Control
                    type="text"
                    value={isSubmitted ? formData.city : null}
                    placeholder="Enter City"
                    onKeyUp={handleChange}
                    name="city"
                  />
                </Form.Group>
              </Form.Group>
            </Col>
          </Row>
        <Row>
          <Col lg={4}>
            <Form.Group className="mb-3">
              <Form.Label className="textbold">Phone No </Form.Label>
              <Form.Control
                type="text"
                value={isSubmitted ? formData.mob : null}
                placeholder="Enter Phone No "
                onKeyUp={handleChange}
                name="mob"
              />
            </Form.Group>
          </Col>

          <Col lg={4}>
            <Form.Group className="mb-3">
              <Form.Group className="mb-3">
                <Form.Label className="textbold">Email </Form.Label>
                <Form.Control
                  type="text"
                  value={isSubmitted ? formData.email : null}
                  placeholder="Enter Email"
                  onKeyUp={handleChange}
                  name="email"
                />
              </Form.Group>
            </Form.Group>
          </Col>

          <Col lg={4}>
            <Form.Group className="mb-3">
              <Form.Label className="textbold">Password</Form.Label>
              <Form.Control
                type="text"
                // change logic on click event and store password
                value={isSubmitted ? formData.password : null}
                placeholder="Enter Password"
                onKeyUp={handleChange}
                name="pass"
              />
            </Form.Group>
          </Col>

        </Row>

        <Row className="justify-content-center mt-3">
          <Col xs="auto">

            <Button
              type='submit'
              variant="success"
              className="textbold"
            >
              Register
            </Button>

          </Col>
          <Col xs="auto">
            <LinkContainer to="/">
              <Button
                variant="danger"
                onClick={handleShow}
                className="textbold"
              >
                Back To Home
              </Button>
            </LinkContainer>
          </Col>
        </Row>
      </Form>
    </div>
    </Container >
  );
}


