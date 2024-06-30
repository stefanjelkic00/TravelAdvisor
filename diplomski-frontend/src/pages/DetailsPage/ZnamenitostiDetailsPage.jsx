import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import customAxios from '../../utils/customAxios';
import Slider from '../../components/Slider';
import {format} from 'date-fns';
import Reakcija from '../../components/Reakcija';
import ReakcijaNoAuth from '../../components/ReakcijaNoAuth';
import {toast} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"
import Map from '../../components/Map';

function ZnamenitostiDetailsPage() {
  const {id} = useParams();
  const [znamenitost , setZnamenitost]= useState();
  const [recenzije , setRecenzije] = useState([]);
  const oceneBoja = {
    1: "red"  , 2: "red" , 3: "yellow" , 4: "orange" , 5: "green"
  };
  const token = sessionStorage.getItem("jwtToken");
  const [prikazDugmeta , setPrikazDugmeta] = useState(true);
  const email = sessionStorage.getItem("email");
  const [show , setShow] = useState(false);
  const [formData , setFormData] = useState({
    ocena:'' , komentar:''
  });
  



  useEffect(()=>{
    try {
      customAxios.get(`http://localhost:8001/api/destinacija/znamenitost/${id}`).then(res=>{
        setZnamenitost(res.data);
      });
      customAxios.get(`http://localhost:8001/api/recenzija/get/destinacija/${id}`).then(res=>{
        console.log("recenzije")
        console.log(res.data)
        setRecenzije(res.data);

        });

    } catch (error) {
      console.log("Nisu uspesno izvuceni podaci ")
    }
  },[])


  useEffect(()=>{
    setPrikazDugmeta(!recenzije.some(r => r.korisnik.email === email ));
  },[recenzije])

    const deleteRecenzija=async(id)=>{
    await customAxios.delete(`http://localhost:8001/api/recenzija/${id}`)
        .then(res => {
            toast.success("Uspesno ste obrisali vasu recenziju");
            const newRecenzije =recenzije.filter(r => r.id !== id);
            setRecenzije(newRecenzije);
        }).catch(error => {
            toast.error("Brisanje ove recenzije nije moguce .");
        });
}

  function openModal(){
    setShow(true);
  }

  function closeModal(){
    setFormData({
      ocena: '' , komentar: ''
    });
    setShow(false);
  }

   function handleChange(e){
    const {name,value} = e.target;
    setFormData({...formData ,[name]: value});
  }

  async function kreirajRecenziju(){
    
    if(formData.ocena == '' ){
      toast.error("Neophodno je da izaberete ocenu.");
    }
    if(formData.komentar == ''){
      toast.error("Neophodno je da unesete komentar.");
      return;
    }

    await customAxios.post("http://localhost:8001/api/recenzija" , {
      ocena : formData.ocena , komentar : formData.komentar , destinacijaID : id 
    }).then(res => {
      toast.success("Uspesno ste kreirali recenziju .");
      setRecenzije([...recenzije , res.data]);
    }).catch(error => {
      toast.error("Recenzija nije kreirana , pokusajte ponovo .");
    })
    closeModal();
  }


  return (

    <div className='container' style={{minHeight:"70vh"}}>


    <div className={`modal ${show ? 'show':''}`} data-bs-backdrop="static" tabIndex="-1" role='dialog' style={{display: show ? 'block':'none'}}>
        <div className='modal-dialog' role='document'>
          <div className='modal-content'>
            <div className='modal-header'>
              <h5 className='modal-title'>
                Forma za kreiranje recenzije :
              </h5>
              <button type='button' className='close btn btn-danger ms-auto' onClick={closeModal}>
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div className='modal-body'>
                <form>
                  <div>
                    <label htmlFor="ocena">Ocena :</label>
                    <br/>
                    <select name="ocena" id="ocena" value={formData.ocena} onChange={handleChange}>
                      <option value="">Izaberite ocenu...</option>
                      <option value={1}>1</option>
                      <option value={2}>2</option>
                      <option value={3}>3</option>
                      <option value={4}>4</option>
                      <option value={5}>5</option>
                    </select>                   
                  </div>
                  <div>
                  
                  <label htmlFor="komentar">Komentar :</label>
                  <br/>
                  <textarea id="komentar" name='komentar' value={formData.komentar} onChange={handleChange}/>

                  </div>
                </form>
            </div>
            <div className='modal-footer'>
                <button type='button' className='btn btn-secondary' onClick={closeModal}>Zatvori</button>
                <button type='button' className='btn btn-primary' onClick={kreirajRecenziju}>Kreiraj</button>
            </div>
          </div>
        </div>
    </div>


      <h1> {znamenitost?.naziv} </h1>
      <hr/>
      <div>
        <Slider data={znamenitost?.slikaDestinacije}/>
        <div >
          <div>
            <h2> Tip smestaja : {znamenitost?.tipSmestaja}</h2>
            <h2>Adresa : {znamenitost?.adresa} </h2>
            {
              znamenitost?.prosecnaOcena ? <h2 style={{color: oceneBoja[Math.floor(znamenitost.prosecnaOcena)]}} >Prosecna ocena : {znamenitost?.prosecnaOcena.toFixed(1)}</h2> : <h2>Prosecna ocena : \</h2>
            }
            <h2> Opis : {znamenitost?.opis}</h2>
          </div>
          
          <div className='d-flex align-items-center justify-content-center'>
            <Map item={znamenitost}/>
          </div>
          
        </div>
      </div>
      <br/>
      <hr/>
      <div>
        {
          prikazDugmeta ? (
            <div className='d-flex flex-row justify-content-around'>
              {
                token ? (
                  <>
                    <h1 style={{marginLeft:"350px"}}>Recenzije znamenitosti :</h1> 
                    <button type='button' className='btn btn-warning btn-sm' onClick={openModal}>Dodaj recenziju</button>
                  </>
                ) : <h1>Recenzije znamenitosti :</h1>
              }
            </div>
          ):<h1>Recenzije znamenitosti :</h1>
        }
      </div>
      
      
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
                  token ? <Reakcija item={item} index={index} deleteRecenzija={deleteRecenzija} />:<ReakcijaNoAuth item={item} index={index} />
                }
              </div>
            </div>
          ))
        }
      </div>
    </div>
  )
}

export default ZnamenitostiDetailsPage