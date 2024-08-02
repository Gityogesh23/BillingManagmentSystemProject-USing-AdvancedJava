import { Container, Nav, NavDropdown, Navbar } from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";
import Logo from '../images/b1.jpeg';
import '../images/navcss.css';

export function NavigationBar() {
    const customNavbarStyle = {
        backgroundColor: '#D3D3D3'
    };
    const navLinkStyle = {
        color: '#EBE3D5' // Change text color to blue for all navbar options
    };

    return (
        <Navbar expand="lg" className="custom-navbar-bg" style={customNavbarStyle}>
            <Container>
                <Navbar.Brand href="#home">
                    <img
                        alt=""
                        src={Logo}
                        width="150"
                        height="50" 
                        className="d-inline-block align-top class3"
                    />{' '}
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <LinkContainer to="/">
                            <Nav.Link className="nav-text align-right">HOME</Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/registration">
                            <Nav.Link className="nav-text align-right">REGISTER</Nav.Link>
                        </LinkContainer>
                    </Nav>
                    <Nav className="ml-auto">
                        <LinkContainer to="/">
                            <NavDropdown
                                id="nav-dropdown-dark-example"
                                title="Login"
                                menuVariant="light"
                                className="nav-text"
                            >
                                <LinkContainer to="/admin-login">
                                    <NavDropdown.Item className="nav-text">Admin Login</NavDropdown.Item>
                                </LinkContainer>
                                <NavDropdown.Divider />
                                <LinkContainer to="/Login">
                                    <NavDropdown.Item className="nav-text">Applicant Login</NavDropdown.Item>
                                </LinkContainer>
                            </NavDropdown>
                        </LinkContainer>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}
