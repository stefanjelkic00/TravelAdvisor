import React, { useEffect, useState } from 'react'
import customAxios from '../../utils/customAxios';
import { useNavigate } from 'react-router-dom';
import { array } from 'yup';
import {toast} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"

function Znamenitosti() {

    const [znamenitosti, setZnamenitosti] = useState([]);
    const navigate = useNavigate();
    const [query,setQuery] = useState('');

    const uloga = sessionStorage.getItem("uloga");
    
    const [show , setShow] = useState(false);
    const [formData , setFormData] = useState({
        longitude:'' , latitude:'' , adresa:'' , naziv:'' , opis:'' , slikeDestinacije:[] , tipZnamenitosti:''
    });


    useEffect(()=>{
        try {
            customAxios.get('http://localhost:8001/api/destinacija/znamenitost').then(res=>{
                console.log(res);
                setZnamenitosti(res.data);
            })
        } catch (error) {
            console.log("Nisu uspesno izvuceni podaci ")
        }
    },[])

    const detailsPage=(id)=>{
        navigate(`/znamenitost-details/${id}`);
    }

    const handleQuery = (e)=>{
        setQuery(e.target.value);
    }

    const handleSearch = async()=>{
        await customAxios.get(`http://localhost:8001/api/destinacija/znamenitostSearch?query=${query}`).then(res => {
            setZnamenitosti(res.data);
            
        }).catch(error => {
            console.log("Pretraga je neuspesna");
        });
    }
    

    function openModal(){
        setShow(true);
      }
    
      function closeModal(){
        setFormData({
          longitude:'' , latitude:'' , adresa:'' , naziv:'' , opis:'' , slikeDestinacije:[] , tipZnamenitosti:''
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

      async function kreirajZnamenitost(){
        if(formData.longitude == '' || formData.latitude =='' || formData.naziv =='' || formData.adresa =='' ||
            formData.setZnamenitosti =='' ){
            toast.error("Neophodno je da unesete sve podatke .");
            return;
        }

        await customAxios.post("http://localhost:8001/api/znamenitost" , {
            longitude: formData.longitude , latitude: formData.latitude , adresa: formData.adresa 
            , naziv: formData.naziv , opis: formData.opis , slikeDestinacije: formData.slikeDestinacije , tipZnamenitosti:formData.tipZnamenitosti
        }).then(res => {
            toast.success("Uspesno ste kreirali znamenitost");
            const znamenitost = res.data;
            console.log(znamenitost);
            setZnamenitosti([...znamenitosti,znamenitost]);
        }).catch(error => {
            toast.error("Znamenitost nije kreirana , pokusajte ponovo");
        });
        closeModal();
      }

       const deleteZnamenitost = async(id) => {
        await customAxios.delete(`http://localhost:8001/api/znamenitost/${id}`)
            .then(res=> {
                toast.success("Uspesno ste obrisali znamenitost .");
                const newZnamenitosti = znamenitosti.filter(r => r.id !==id);
                setZnamenitosti(newZnamenitosti);
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
                    Forma za kreiranje znamenitosti :
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
                            <label htmlFor="tipZnamenitosti">Tip znamenitosti :</label>
                            <br/>
                            <select name="tipZnamenitosti" id="tipZnamenitosti" value={formData.tipZnamenitosti} onChange={handleChange}>
                            <option value="">Izaberite tip znamenitosti...</option>
                            <option value={"SPOMENIK"}>SPOMENIK</option>
                            <option value={"MUZEJ"}>MUZEJ</option>
                            <option value={"FONTANA"}>FONTANA</option>
                            <option value={"VODOPAD"}>VODOPAD</option>
                            <option value={"TORANJ"}>TORANJ</option>
                            <option value={"ISTORIJSKE_ZNAMENISTOSI"}>ISTORIJSKE_ZNAMENISTOSI</option>
                            <option value={"TRZNI_CENTAR"}>TRZNI_CENTAR</option>
                            </select>                   
                        </div>
                    </form>
                </div>
                <div className='modal-footer'>
                    <button type='button' className='btn btn-secondary' onClick={closeModal}>Zatvori</button>
                    <button type='button' className='btn btn-primary' onClick={kreirajZnamenitost} >Kreiraj</button>
                </div>
            </div>
            </div>
        </div>




        <h1 >Znamenitost</h1>
        <div className='d-flex align-items-center justify-content-center'>
            {
                uloga == "ROLE_ADMIN" ?
                (
                    <div style={{marginLeft:'150px'}}>
                        <input type='text' className='me-3' placeholder='Pretraži' value={query} onChange={handleQuery}/>
                        <button type='button' className='btn btn-primary' onClick={handleSearch}>Pretraga</button>
                        <button type='button' className='btn btn-warning ' style={{position:'relative' , left:'350px'}} 
                        onClick={openModal}>Dodaj Znamenitost</button>
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
        znamenitosti.map(r =>(
            <div className='card me-3 mt-3'style={{width: "350px" , height:"450px"}} key={r.id}>
                <img className='card-img-top'  style={{height: "255px"}} src={require(`../../assets/${r?.slikaDestinacije[0]?.putanja}`)}/>
                
                <div className='card-body'>
                    <h4 className='card-title'>{r.naziv}</h4>
                    <h5 className='card-subtitle mb-2 text-muted'>{r.tipZnamenitosti}</h5>
                    <h5 className='card-subtitle mb-2 text-muted'>{r.adresa} </h5>
                </div>
                <div className='card-footer'>
                    <button className='btn btn-warning btn-sm' onClick={() => detailsPage(r.id)}>Detaljnije</button>
                    {
                        uloga == "ROLE_ADMIN" && <button className='btn btn-danger btn-sm ms-2' onClick={() => deleteZnamenitost(r.id)}>Obrisi</button>
                    }
                </div>
            </div>
        ))
       }
        
        
    </div>
    </div>
  )
}

export default Znamenitosti