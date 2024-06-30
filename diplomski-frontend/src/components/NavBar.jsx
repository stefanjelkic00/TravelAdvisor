import React from 'react'
import { Link, useNavigate } from 'react-router-dom';
import {toast} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"

function NavBar() {

    const navigate = useNavigate();
    const token = sessionStorage.getItem("jwtToken");
    const username = sessionStorage.getItem("email")?.split("@")[0];

    function logout(){
        sessionStorage.clear();
        toast.success("Uspesno ste se odjavili .")
        setTimeout(() => {
            navigate("/");
        }, 1000);
        
        
    }
  return (
    <div>
        <nav className='navbar navbar-expand-lg navbar-dark bg-primary'>        
            <a  className='navbar-brand ms-4' href='/'>Travel advisor</a>
            <div className='collapse navbar-collapse' >
            { token == null ? (
                <ul className='navbar-nav mrc-auto'>
                    <li className='nav-item active'>
                        <Link className='nav-link' to="/">
                            Početna stranica
                        </Link>
                    </li>       
                    <li className='nav-item'>
                        <Link className='nav-link' to="/login">
                            Prijava
                        </Link>
                    </li>
                    <li className='nav-item '>
                        <Link className='nav-link' to="/registration">
                            Registracija
                        </Link>
                    </li>
                        
                    
                </ul>
                ):(
                    <ul className='navbar-nav mrs-auto w-100 '>
                        <li className='nav-item active'>
                            <Link className='nav-link' to="/">
                                Početna stranica
                            </Link>
                        </li>
                        <li className='nav-item ms-auto'>
                            <p className='text-white m-2'>Korisničko ime : {username}</p>
                        </li>
                        <li className='nav-item ms-2 me-5'>
                            <button type='button' className='btn btn-danger' onClick={()=> logout()}>Odjava </button>
                        </li>        
                    </ul>
                )
            }
            </div>     
        </nav>
    </div>
  )
}

export default NavBar