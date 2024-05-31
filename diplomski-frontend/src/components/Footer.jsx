import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faFacebook, faInstagram, faLinkedin, faTwitter } from '@fortawesome/free-brands-svg-icons'

function Footer() {
  return (
    
    <footer className="bg-primary text-white text-center p-3 ">
    <div className="container">
       <div className="row">
          <div className="col">
             <h4>Follow us </h4>
             <ul className="list-inline " style={{margin:0,padding:0}}>
                <li className="list-inline-item"> <a href="#"><FontAwesomeIcon icon={faFacebook} style={{color: "white"}}/></a> </li>
                <li className="list-inline-item"> <a href="#"><FontAwesomeIcon icon={faTwitter} style={{color: "white"}}/> </a> </li>
                <li className="list-inline-item"> <a href="#"><FontAwesomeIcon icon={faInstagram} style={{color: "white"}}/></a> </li>
                <li className="list-inline-item"> <a href="#"><FontAwesomeIcon icon={faLinkedin} style={{color: "white"}}/></a> </li>
             </ul>
          </div>
       </div>
    </div>
    <div className="container-fluid">
       <div className="row">
          <div className="col">
             <p className="mb-0">© 2024 Travel Advisor. All Rights Reserved. </p>
          </div>
       </div>
    </div>
 </footer>
   
  )
}

export default Footer