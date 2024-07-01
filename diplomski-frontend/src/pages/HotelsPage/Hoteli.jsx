import React, { useEffect, useState } from 'react'
import customAxios from '../../utils/customAxios';
import { useNavigate } from 'react-router-dom';


function Hoteli() {

    const [hoteli, setHoteli] = useState([]);
    const navigate = useNavigate();

    useEffect(()=>{
        try {
            customAxios.get('http://localhost:8001/api/destinacija/smestaj').then(res=>{
                console.log(res);
                setHoteli(res.data);
            })
        } catch (error) {
            console.log("Nisu uspesno izvuceni podaci ")
        }
    },[])

    const detailsPage=(id)=>{
        navigate(`/hotel-details/${id}`);
    }
    
  return (
    <div className='container'>
        <h1 >Smeštaj</h1>
        <hr />
    <div className='mt-3 d-flex p-4 flex-wrap justify-content-around'>
       {
        hoteli.map(r =>(
            <div className='card me-3 mt-3'style={{width: "350px" , height:"450px"}} key={r.id}>
                <img className='card-img-top'  style={{height: "255px"}} src={require(`../../assets/${r.slikaDestinacije[0].putanja}`)}/>
                <div className='card-body'>
                    <h4 className='card-title'>{r.naziv}</h4>
                    <h5 className='card-subtitle mb-2 text-muted'>{r.tipSmestaja}</h5>
                    <h5 className='card-subtitle mb-2 text-muted'>{r.adresa} </h5>
                </div>
                <div className='card-footer'>
                    <button className='btn btn-warning btn-sm' onClick={() => detailsPage(r.id)}>Detaljnije</button>
                </div>
            </div>
        ))
       }
        
        
    </div>
    </div>
  )
}

export default Hoteli