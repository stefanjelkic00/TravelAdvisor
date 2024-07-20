import './App.css';
import {BrowserRouter as Router , Route , Routes} from 'react-router-dom';
import Home from './pages/HomePage/Home';
import NavBar from './components/NavBar';
import Footer from './components/Footer';
import Login from './pages/LoginPage/Login';
import Registration from './pages/RegistrationPage/Registration';
import { ToastContainer} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"
import Restorani from './pages/RestoranPage/Restorani';
import RestoraniDetailsPage from './pages/DetailsPage/RestoraniDetailsPage';
import Hoteli from './pages/HotelsPage/Hoteli';
import Znamenitosti from './pages/ZnamenitostiPage/Znamenitosti';
import ZnamenitostiDetailsPage from './pages/DetailsPage/ZnamenitostiDetailsPage'
import HoteliDetailsPage from './pages/DetailsPage/HoteliDetailsPage';

function App() {
  return (
    <div className="App">
      <Router>
        <div>
          <Routes>
            <Route path='/login' element={<div><NavBar/><ToastContainer position='top-center' autoClose={2000}/><Login/><Footer/></div>}/>
            <Route path='/registration' element={<div><NavBar/><ToastContainer position='top-center'autoClose={2000}/><Registration/><Footer/></div>}/> 
            
            <Route path='/restorani' element={<div><NavBar/><ToastContainer position='top-center' autoClose={2000}/><Restorani/><Footer/></div>}/>
            <Route path='/restoran-details/:id' element={<div><NavBar/><RestoraniDetailsPage/><Footer/></div>}/>

            <Route path='/hoteli' element={<div><NavBar/><ToastContainer position='top-center' autoClose={2000}/><Hoteli/><Footer/></div>}/> 
            <Route path='/hotel-details/:id' element={<div><NavBar/><ToastContainer position='top-center' autoClose={2000}/><HoteliDetailsPage/><Footer/></div>}/>

            <Route path='/znamenitosti' element={<div><NavBar/><ToastContainer position='top-center' autoClose={2000}/><Znamenitosti/><Footer/></div>}/>
            <Route path='/znamenitost-details/:id' element={<div><NavBar/><ZnamenitostiDetailsPage/><Footer/></div>}/>

            <Route path='/' element={<div><NavBar/><ToastContainer position='top-center'autoClose={2000}/><Home/><Footer/></div>}/>
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
