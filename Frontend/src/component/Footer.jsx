import { Container } from "react-bootstrap";
// import { FaFacebook, FaInstagram, FaLinkedin, FaTwitter } from 'react-icons/fa';
import '../images/Footer.css';


export function Footer() {
  return (
    <Container className="mt-5">
      <footer id="footer">
      {/* <div className="footer-newsletter">
          <div className="container">
          
            <div className="row">
              <div className="col-lg-6">
                <h4>Our Newsletter</h4>
                <p>Tamen quem nulla quae legam multos aute sint culpa legam noster magna</p>
              </div>
              <div className="col-lg-6">
                <form action="" method="post">
                  <input type="email" name="email" />
                  <input type="submit" value="Subscribe" />
                </form>
              </div>
            </div>
          </div>
        </div> */}
        <div className="footer-top">
          <div className="container">
            <div className="row">
              <div className="col-lg-3 col-md-6 footer-links">
                <h4>Useful Links</h4>
                <ul>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Home</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">About us</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Services</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Terms of service</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Privacy policy</a></li>
                </ul>
              </div>
              <div className="col-lg-3 col-md-6 footer-links">
                <h4>Our Services</h4>
                <ul>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Web Design</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Web Development</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Product Management</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Marketing</a></li>
                  <li><i className="bx bx-chevron-right"></i> <a href="#">Graphic Design</a></li>
                </ul>
              </div>
              <div className="col-lg-3 col-md-6 footer-contact">
                <h4>Contact Us</h4>
                <p>
                  CDAC Mumbai <br />
                  Kharghar, Navi Mumbai<br />
                  Maharashtra, India <br /><br />
                  <strong>Phone:</strong> +91 2244 6722 99<br />
                  <strong>Email:</strong> cdac@example.com<br />
                </p>
              </div>
              <div className="col-lg-3 col-md-6 footer-info">
                <h3>About Our Team</h3>
                <p style={{textAlign:'justify'}}>Individually, each member brings a unique set of skills and experiences to the table, but together, we form a cohesive unit dedicated to achieving our mission. We thrive on collaboration, creativity, and a shared commitment to delivering excellence in everything we do.</p>
                {/* <div className="social-links mt-3">
                  <a href="#" className="twitter"><i className="bx bxl-twitter"></i></a>
                  <a href="#" className="facebook"><i className="bx bxl-facebook"></i></a>
                  <a href="#" className="instagram"><i className="bx bxl-instagram"></i></a>
                  <a href="#" className="linkedin"><i className="bx bxl-linkedin"></i></a>
                </div> */}
                {/* <div className="social-links mt-3">
                    <a href="#" className="twitter"><FaTwitter /></a>
                    <a href="#" className="facebook"><FaFacebook /></a>
                    <a href="#" className="instagram"><FaInstagram /></a>
                    <a href="#" className="linkedin"><FaLinkedin /></a>
                </div> */}
              </div>
            </div>
          </div>
        </div>
        <div className="container">
          <div className="copyright">
            &copy; Copyright <strong><span>Team 43</span></strong>. All Rights Reserved
          </div>
          <div className="credits">
            Designed by <a href="#">Team 43</a>
          </div>
        </div>
      </footer>
    </Container>
  );
}
