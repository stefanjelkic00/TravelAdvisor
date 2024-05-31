import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import customAxios from '../../utils/customAxios';
import Slider from '../../components/Slider';

function RestoraniDetailsPage() {
  const {id} = useParams();
  const [restoran , setRestoran]= useState();
  const [recenzije , setRecenzije] = useState();

  useEffect(()=>{
    try {
      customAxios.get(`http://localhost:8001/api/destinacija/restoran/${id}`).then(res=>{
        setRestoran(res.data);
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
      <h1> {restoran?.naziv} </h1>
      <hr/>
      <div>
        <Slider data={restoran?.slikaDestinacije}/>
        <div>
          <div>
            <h2> Tip restorana : {restoran?.tipRestorana}</h2>
            <h2>Adresa : {restoran?.adresa} </h2>
            {
              restoran?.prosecnaOcena ? <h2>Prosecna ocena : {restoran?.prosecnaOcena}</h2> : <h2>Prosecna ocena : \</h2>
            }
            <h2> Opis : {restoran?.opis}</h2>
          </div>
        </div>
      </div>
    </div>
  )
}

export default RestoraniDetailsPage