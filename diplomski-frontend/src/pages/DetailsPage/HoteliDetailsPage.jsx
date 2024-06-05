import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import customAxios from '../../utils/customAxios';
import Slider from '../../components/Slider';
import {format} from 'date-fns';
import Reakcija from '../../components/Reakcija';
import ReakcijaNoAuth from '../../components/ReakcijaNoAuth';


function HoteliDetailsPage() {
  const {id} = useParams();
  const [hotel , setHotel]= useState();
  const [recenzije , setRecenzije] = useState([]);
  const oceneBoja = {
    1: "red"  , 2: "red" , 3: "yellow" , 4: "orange" , 5: "green"
  };
  const token = sessionStorage.getItem("jwtToken");
  



  useEffect(()=>{
    try {
      customAxios.get(`http://localhost:8001/api/destinacija/smestaj/${id}`).then(res=>{
        setHotel(res.data);
      });
      customAxios.get(`http://localhost:8001/api/recenzija/destinacija/${id}`).then(res=>{
        console.log("recenzije")
        console.log(res.data)
        setRecenzije(res.data);

        });

    } catch (error) {
      console.log("Nisu uspesno izvuceni podaci ")
    }
  },[])
  return (

    <div className='container' style={{minHeight:"70vh"}}>
      <h1> {hotel?.naziv} </h1>
      <hr/>
      <div>
        <Slider data={hotel?.slikaDestinacije}/>
        <div>
          <div>
            <h2> Tip smestaja : {hotel?.tipSmestaja}</h2>
            <h2>Adresa : {hotel?.adresa} </h2>
            {
              hotel?.prosecnaOcena ? <h2>Prosecna ocena : {hotel?.prosecnaOcena}</h2> : <h2>Prosecna ocena : \</h2>
            }
            <h2> Opis : {hotel?.opis}</h2>
          </div>
        </div>
      </div>
      <br/>
      <hr/>
      <h1>Recenzije smestaja : </h1>
      
      <div className='container mt-3 d-flex p-4 flex-wrap align-items-center justify-content-center '>
        {
          recenzije.map((item,index)=>(
            <div className='card' key={index} style={{width: "60%" , marginBottom: "15px"}}>
              <div className='card-body'>
                <h4 className='card-title'>Autor : {item.korisnik.ime} {item.korisnik.prezime}</h4>
                <h4 className='card-subtitle mb-2 text-muted'>Datum : {format(item.datum , "yyyy-MM-dd")}</h4>
                <h5 className='card-subtitle mb-2' style={{color: oceneBoja[item.ocena]}}>Ocena : {item.ocena} </h5>
                <hr/>
                <p className='card-text'>Komentar : {item.komentar}</p>
              </div>
              <div className='card-footer'>
                {
                  token ? <Reakcija item={item} index={index}/>:<ReakcijaNoAuth item={item} index={index} />
                }
                
              </div>
            </div>
          ))
        }
      </div>
    </div>
  )
}

export default HoteliDetailsPage