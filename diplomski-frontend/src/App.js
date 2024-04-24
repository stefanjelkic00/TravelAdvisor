import './App.css';
import {BrowserRouter as Router , Route , Routes} from 'react-router-dom';
import Home from './pages/HomePage/Home';
import NavBar from './components/NavBar';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      <Router>
        <div>
          <Routes>
            <Route path='/' element={<div><NavBar/><Home/><Footer/></div>}/>
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
