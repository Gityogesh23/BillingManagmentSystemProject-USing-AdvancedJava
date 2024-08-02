
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Col, Container, Form, Row } from "react-bootstrap";
import axios from 'axios';


export function MobilePage() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    customerName: '',
    phoneNumber: '',
    amount: '',
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
      const response = await axios.post('http://localhost:8080/topup',formData);
      console.log(response.data);
      alert("Tansaction Successfull");
      navigate('/');
    } catch (error) {
      console.error('Error submitting the form:', error.message);
    }
  };
  return (
    <Container className="container d-flex justify-content-center">
    <Form onSubmit={handleSubmit}>
      <Row>
          <Col lg={12}>
            <Form.Group className="mb-3">
              <Form.Label>Customer Name:</Form.Label>
              <Form.Control
                type="text"
                name="customerName"
                value={formData.customerName}
                onChange={handleChange}
                required
              />
            </Form.Group>
          </Col>
        </Row>
        <Row>  
          <Col lg={12}>
            <Form.Group className="mb-3">
              <Form.Label>Phone Number:</Form.Label>
              <Form.Control
                type="text"
                name="meterNumber"
                value={formData.meterNumber}
                onChange={handleChange}
                required
              />
            </Form.Group>
          </Col>
        </Row>
        <Row>
          <Col lg={12}>
            <Form.Group className="mb-3">
              <Form.Label>Recharge Amount (in ₹):</Form.Label>
              <Form.Control
                type="number"
                name="amount"
                value={formData.amount}
                onChange={handleChange}
                required
              />
            </Form.Group>
          </Col>
        </Row>

        <Row className="justify-content-center mt-3">
          <Col xs="auto">
            <Button type="submit" variant="success">
              Pay Now
            </Button>
          </Col>
        </Row>
      </Form>
      </Container>
      
    
  );
}


