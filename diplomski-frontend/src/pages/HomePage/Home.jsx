import React from 'react'
import hoteli from '../../assets/hoteli.jpg';
import restorani from '../../assets/restorani.jpg';
import znamenitosti from '../../assets/znamenitosti.jpg';

import  "./home.css";
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div className='container' style={{minHeight:"76.5vh"}}>
        <h1  className='text-primary'  style={{margin: "20px"  , fontFamily: 'serif'}}>Dobrodosli na Travel Advisor  </h1>
        <h2 className='text-primary' style={{paddingBottom: "40px" , fontFamily: 'serif'}} >   Ovde cete moci da pogledate i da se informisete o svim vaznostima vezano za putovanja</h2>
        <div className='container card-container'>
        
                <div style={{width:"25rem"}}>
                    <Link  to='/hoteli' className='card bg-dark text-white' >
                        <img src={hoteli} alt="hoteli" style={{width:"398px", height:"280px"}} />
                        <div className='card-img-overlay'>
                        <h2 className='card-title' style={{fontFamily: 'serif'}}> Smestaji </h2>
                        </div> 
                    </Link>       
                </div>
                <div style={{width:"25rem"}}>
                    <Link  to='/restorani' className='card bg-dark text-white' >
                        <img src={restorani} alt="restorani" style={{width:"398px" , height:"280px"}}/>
                        <div className='card-img-overlay'>
                        <h2 className='card-title ' style={{fontFamily: 'serif'}}> Restorani </h2>
                        </div> 
                    </Link>       
                </div>
                <div style={{width:"25rem"}}>
                    <Link  to='/znamenitosti' className='card bg-dark text-white' >
                        <img src={znamenitosti} alt="znamenitosti" style={{width:"398px" , height:"280px"}}/>
                        <div className='card-img-overlay'>
                        <h2 className='card-title ' style={{fontFamily: 'serif'}}> Znamenitosti </h2>
                        </div> 
                    </Link>       
                </div>
        </div>
    </div>
    
  )
}

export default Home