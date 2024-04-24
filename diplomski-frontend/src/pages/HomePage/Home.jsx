import React from 'react'
import hoteli from '../../assets/hoteli.jpg';
import  "./home.css";

function Home() {
  return (
    <div className='container'>
        <h1  className='text-primary'  style={{margin: "20px"  , fontFamily: 'serif'}}>Dobrodosli na Travel Advisor  </h1>
        <h2 className='text-primary' style={{paddingBottom: "40px" , fontFamily: 'serif'}} >   Ovde cete moci da pogledate i da se informisete o svim vaznostima vezano za putovanja</h2>
        <div className='container card-container'>
        
                <div style={{width:"25rem"}}>
                    <a  href='#' className='card bg-dark text-white' >
                        <img src={hoteli} alt="hoteli" />
                        <div className='card-img-overlay'>
                        <h2 className='card-title '> Hoteli </h2>
                        </div> 
                    </a>       
                </div>
                <div style={{width:"25rem"}}>
                    <a  href='#' className='card bg-dark text-white' >
                        <img src={hoteli} alt="hoteli" />
                        <div className='card-img-overlay'>
                        <h2 className='card-title '> Restorani </h2>
                        </div> 
                    </a>       
                </div>
                <div style={{width:"25rem"}}>
                    <a  href='#' className='card bg-dark text-white' >
                        <img src={hoteli} alt="hoteli" />
                        <div className='card-img-overlay'>
                        <h2 className='card-title '> Destinacije </h2>
                        </div> 
                    </a>       
                </div>
        </div>
    </div>
    
  )
}

export default Home