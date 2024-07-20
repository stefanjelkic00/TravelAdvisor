import React, { useEffect, useState } from 'react'
import customAxios from '../../utils/customAxios';
import { useNavigate } from 'react-router-dom';
import { array } from 'yup';
import {toast} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"

function Hoteli() {

    const [hoteli, setHoteli] = useState([]);
    const navigate = useNavigate();
    const [query,setQuery] = useState('');

    const uloga = sessionStorage.getItem("uloga");
    
    const [show , setShow] = useState(false);
    const [formData , setFormData] = useState({
        longitude:'' , latitude:'' , adresa:'' , naziv:'' , opis:'' , slikeDestinacije:[] , tipSmestaja:''
    });


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

    const handleQuery = (e)=>{
        setQuery(e.target.value);
    }

    const handleSearch = async()=>{
        await customAxios.get(`http://localhost:8001/api/destinacija/smestajSearch?query=${query}`).then(res => {
            setHoteli(res.data);
            
        }).catch(error => {
            console.log("Pretraga je neuspesna");
        });
    }
    

    function openModal(){
        setShow(true);
      }
    
      function closeModal(){
        setFormData({
          longitude:'' , latitude:'' , adresa:'' , naziv:'' , opis:'' , slikeDestinacije:[] , tipSmestaja:''
        });
        setShow(false);
      }

      function handleChange(e){
        const {name,value} = e.target;
        setFormData({...formData ,[name]: value});
      }
      function handleFileChange(e){
        const slikeDestinacije =Array.from( e.target.files).map(s => s.name);
        setFormData({...formData ,slikeDestinacije: slikeDestinacije});
      }

      async function kreirajSmestaj(){
        if(formData.longitude == '' || formData.latitude =='' || formData.naziv =='' || formData.adresa =='' ||
            formData.tipSmestaja =='' ){
            toast.error("Neophodno je da unesete sve podatke .");
            return;
        }

        await customAxios.post("http://localhost:8001/api/smestaj" , {
            longitude: formData.longitude , latitude: formData.latitude , adresa: formData.adresa 
            , naziv: formData.naziv , opis: formData.opis , slikeDestinacije: formData.slikeDestinacije , tipSmestaja:formData.tipSmestaja
        }).then(res => {
            toast.success("Uspesno ste kreirali smestaj");
            const hotel = res.data;
            console.log(hotel);
            setHoteli([...hoteli,hotel]);
        }).catch(error => {
            toast.error("Smestaj nije kreiran , pokusajte ponovo");
        });
        closeModal();
      }

       const deleteSmestaj = async(id) => {
        await customAxios.delete(`http://localhost:8001/api/smestaj/${id}`)
            .then(res=> {
                toast.success("Uspesno ste obrisali smestaj .");
                const newHoteli = hoteli.filter(r => r.id !==id);
                setHoteli(newHoteli);
            }).catch(error =>{
                toast.error("Brisanje nije uspesno .");
            })
       }

   

  return (
    <div className='container'>


    <div className={`modal ${show ? 'show':''}`} data-bs-backdrop="static" tabIndex="-1" role='dialog' style={{display: show ? 'block':'none'}}>
            <div className='modal-dialog' role='document'>
            <div className='modal-content'>
                <div className='modal-header'>
                <h5 className='modal-title'>
                    Forma za kreiranje smeštaja :
                </h5>
                <button type='button' className='close btn btn-danger ms-auto' onClick={closeModal}>
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div className='modal-body'>
                    <form>
                        
                        <div >
                            <label htmlFor="longitude">Longitude :</label>
                            <br/>
                            <input type="number"  id="longitude" name="longitude" value={formData.longitude} onChange={handleChange} required/>
                        </div>
                        <div >
                            <label htmlFor="latitude">Latitude :</label>
                            <br/>
                            <input type="number" id="latitude" name="latitude" value={formData.latitude} onChange={handleChange} required/>
                        </div>
                        <div>
                            <label htmlFor="adresa">Adresa :</label>
                            <br/>
                            <input type="text" id="adresa" name="adresa" value={formData.adresa} onChange={handleChange} required/>
                        </div>
                        <div>
                            <label htmlFor="naziv">Naziv :</label>
                            <br/>
                            <input type="text" id="naziv" name="naziv" value={formData.naziv} onChange={handleChange} required/>
                        </div>
                        <div>
                            <label htmlFor="slikeDestinacije">Slike destinacije :</label>
                            <br/>
                            <input type="file" className='ms-5' id="slikeDestinacije" name="slikeDestinacije" 
                            onChange={handleFileChange} accept='image/*' multiple required/>
                        </div>
                        
                    
                        <div>
                            <label htmlFor="opis">Opis :</label>
                            <br/>
                            <textarea id="opis" name='opis' value={formData.opis} onChange={handleChange}/>
                        </div>
                        <div>
                            <label htmlFor="tipSmestaja">Tip smeštaja :</label>
                            <br/>
                            <select name="tipSmestaja" id="tipSmestaja" value={formData.tipSmestaja} onChange={handleChange}>
                            <option value="">Izaberite tip smeštaja...</option>
                            <option value={"HOTEL"}>HOTEL</option>
                            <option value={"MOTEL"}>MOTEL</option>
                            <option value={"APARTMAN"}>APARTMAN</option>
                            </select>                   
                        </div>
                    </form>
                </div>
                <div className='modal-footer'>
                    <button type='button' className='btn btn-secondary' onClick={closeModal}>Zatvori</button>
                    <button type='button' className='btn btn-primary' onClick={kreirajSmestaj} >Kreiraj</button>
                </div>
            </div>
            </div>
        </div>




        <h1 >Smeštaj</h1>
        <div className='d-flex align-items-center justify-content-center'>
            {
                uloga == "ROLE_ADMIN" ?
                (
                    <div style={{marginLeft:'150px'}}>
                        <input type='text' className='me-3' placeholder='Pretraži' value={query} onChange={handleQuery}/>
                        <button type='button' className='btn btn-primary' onClick={handleSearch}>Pretraga</button>
                        <button type='button' className='btn btn-warning ' style={{position:'relative' , left:'350px'}} 
                        onClick={openModal}>Dodaj Smeštaj</button>
                    </div>
                ):(
                    <div>
                        <input type='text' className='me-3' placeholder='Pretraži' value={query} onChange={handleQuery}/>
                        <button type='button' className='btn btn-primary' onClick={handleSearch}>Pretraga</button>
                    </div>
                )
            }
        </div>
        <hr />
    <div className='mt-3 d-flex p-4 flex-wrap justify-content-around'>
       {
        hoteli.map(r =>(
            <div className='card me-3 mt-3'style={{width: "350px" , height:"450px"}} key={r.id}>
                <img className='card-img-top'  style={{height: "255px"}} src={require(`../../assets/${r?.slikaDestinacije[0]?.putanja}`)}/>
                
                <div className='card-body'>
                    <h4 className='card-title'>{r.naziv}</h4>
                    <h5 className='card-subtitle mb-2 text-muted'>{r.tipSmestaja}</h5>
                    <h5 className='card-subtitle mb-2 text-muted'>{r.adresa} </h5>
                </div>
                <div className='card-footer'>
                    <button className='btn btn-warning btn-sm' onClick={() => detailsPage(r.id)}>Detaljnije</button>
                    {
                        uloga == "ROLE_ADMIN" && <button className='btn btn-danger btn-sm ms-2' onClick={() => deleteSmestaj(r.id)}>Obrisi</button>
                    }
                </div>
            </div>
        ))
       }
        
        
    </div>
    </div>
  )
}

export default Hoteli