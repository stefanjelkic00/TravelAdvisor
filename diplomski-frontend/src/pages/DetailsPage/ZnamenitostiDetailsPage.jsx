import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import customAxios from '../../utils/customAxios';
import Slider from '../../components/Slider';

function ZnamenitostiDetailsPage() {
  const {id} = useParams();
  const [znamenitost , setZnamenitost]= useState();
  const [recenzije , setRecenzije] = useState();

  useEffect(()=>{
    try {
      customAxios.get(`http://localhost:8001/api/destinacija/znamenitost/${id}`).then(res=>{
        setZnamenitost(res.data);
      });
      customAxios.get(`http://localhost:8001/api/recenzija/destinacija/${id}`).then(res=>{
        console.log("recenzije")
        console.log(res.data)
        })
    } catch (error) {
      console.log("Nisu uspesno izvuceni podaci ")
    }
  },[])
  return (

    <div className='container' style={{minHeight:"70vh"}}>
      <h1> {znamenitost?.naziv} </h1>
      <hr/>
      <div>
        <Slider data={znamenitost?.slikaDestinacije}/>
        <div>
          <div>
            <h2> Tip znamenitosti : {znamenitost?.tipZnamenitosti}</h2>
            <h2>Adresa : {znamenitost?.adresa} </h2>
            {
              znamenitost?.prosecnaOcena ? <h2>Prosecna ocena : {znamenitost?.prosecnaOcena}</h2> : <h2>Prosecna ocena : \</h2>
            }
            <h2> Opis : {znamenitost?.opis}</h2>
          </div>
        </div>
      </div>
    </div>
  )
}

export default ZnamenitostiDetailsPage