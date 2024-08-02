import { Button, Card, Col, Container, Row, Carousel } from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";
import img1 from "../images/img1.jpg"
import img2 from "../images/img2.jpeg";
import img3 from "../images/img3.jpeg";
import img4 from "../images/img4.jpeg";
import img5 from "../images/img5.jpg";
import img6 from "../images/images3.jpeg";

export function Home() {
  return (
    //hello this is my new comment i have added
    <Container>
      {/* <Header text="Welcome to Student CRUD APP"></Header> */}
      <style>
        {`
          body {
            background-color:#ffffff; 
          }
        `}
      </style>
      <p>Step into seamless transactions and effortless payments! </p>
      <Container className="middlebody">
        <Row>
          {
            <Carousel>
              <Carousel.Item interval={1000}>
                <img className="d-block w-100" src={img1} alt="Canada" />
                <Carousel.Caption></Carousel.Caption>
              </Carousel.Item>
              <Carousel.Item interval={500}>
                <img
                  className="d-block w-100 h-50"
                  src={img2}
                  alt="Second slide"
                />
                <Carousel.Caption></Carousel.Caption>
              </Carousel.Item>
              <Carousel.Item>
                <img className="d-block w-100" src={img3} alt="Third slide" />
                <Carousel.Caption></Carousel.Caption>
              </Carousel.Item>
            </Carousel>
          }
        </Row>

        <Row className="justify-content-md-center mt-5">
          <Col lg={3} style={{ marginRight: '100px' }}>
            <Card style={{ width: "22rem" }}>
              <Card.Img className="img1" variant="top" src={img5} />
              <Card.Body className="text-center">
                <Card.Title>Electricity bill</Card.Title>
                <Card.Text>
                Electricity is needed in almost every sphere of life now. We need it to lead a comfortable life full of all amenities and services. The world will become dormant without electricity.
                </Card.Text>

                <LinkContainer to="/electricity"> 

                <Button
                  variant="primary"
                  className="mt-3"
                  target="_blank">
                  Know more...
                </Button>

                 </LinkContainer> 
              </Card.Body>
            </Card>
          </Col>
          
          <Col lg={3} style={{ marginRight: '100px' }}>
            <Card style={{ width: "22rem" }}>
              <Card.Img className="img2" variant="top" src={img3} />
              <Card.Body className="text-center">
                <Card.Title>Mobile bill</Card.Title>
                <Card.Text>
                Mobile phones are one of the most commonly used gadgets in today’s world. Everyone from a child to an adult uses mobile phones these days. They are indeed very useful and help us in so many ways.
                </Card.Text>
                 <LinkContainer to="/mobilerecharge"> 

                <Button
                  variant="primary"
                  className="mt-3"
                  target="_blank">
                  Know more...
                </Button>

                </LinkContainer>
              </Card.Body>
            </Card>
          </Col>

        </Row>
      </Container>
    </Container>
  );
}
