
import './App.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Home } from "./component/Home";
import { Footer } from "./component/Footer";
import { Login } from "./component/Login";
import { NavigationBar } from "./component/NavigationBar";
import { Registration } from "./component/Registration";
import { Admin } from "./component/Admin";
import { EditUser } from "./component/EditUser";
import { ElectricityPage } from './component/ElectricityPage';
import { MobilePage } from './component/MobilePage';
import { AdminLogin } from './component/AdminLogin';


function App() {
  return (
    <BrowserRouter>
      <NavigationBar></NavigationBar>
      <Routes>
        <Route path="/" element={<Home/>}></Route>
        <Route path="/registration" element={<Registration/>}></Route>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/admin" element={<Admin/>}></Route>
        <Route path="/editUser" element={<EditUser/>}></Route>
        <Route path="/electricity" element={<ElectricityPage/>}></Route>
        <Route path="/mobilerecharge" element={<MobilePage/>}></Route>
        <Route path="/admin-login" element={<AdminLogin/>}></Route>

        
      </Routes>
      <Footer></Footer>
    </BrowserRouter>
  );
}

export default App;
