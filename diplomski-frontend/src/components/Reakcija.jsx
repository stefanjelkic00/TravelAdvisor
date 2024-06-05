import React, { useEffect, useState } from 'react'
import Button from 'react-bootstrap/Button';
import { ButtonGroup, ToggleButton } from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome' 
import {faThumbsUp , faThumbsDown} from '@fortawesome/free-solid-svg-icons';
import customAxios from '../utils/customAxios';

function Reakcija({item , index}) {
    const [likeStatus , setLikeStatus] = useState(false);
    const [unlikeStatus , setUnlikeStatus] = useState(false);
    const [brojSvidjanja , setBrojSvidjanja] = useState(item.brojSvidjanja);
    const [brojNesvidjanja , setBrojNesvidjanja] = useState(item.brojNesvidjanja);

    useEffect(()=>{
         customAxios.get(`http://localhost:8001/api/reakcija/recenzija/${item.id}`).then(res=>{
            console.log(res.data.svidjanje)
            if(res.data.svidjanje === true){
                setLikeStatus(true);
            }
            else if(res.data.svidjanje === false){
                setUnlikeStatus(false);
            }
        })
    },[]); 

    async function handleLikeClick(){
        setLikeStatus(!likeStatus);
        setUnlikeStatus(false);
        if(likeStatus === false && unlikeStatus === false){
            setBrojSvidjanja(brojSvidjanja +1);
            await customAxios.post("http://localhost:8001/api/reakcija" , {
                svidjanje: true , 
                recenzija_id: item.id
            });
        }
        else if(likeStatus === true && unlikeStatus === false){
            setBrojSvidjanja(brojSvidjanja - 1);
            await customAxios.delete(`http://localhost:8001/api/reakcija/${item.id}`);
            
        }
        else if(likeStatus === false && unlikeStatus === true){
            setBrojNesvidjanja(brojNesvidjanja - 1);
            setBrojSvidjanja(brojSvidjanja + 1);
            await customAxios.put("http://localhost:8001/api/reakcija" , {
                id: item.id
            });
        }
    }
    async function handleUnlikeClick(){
        setUnlikeStatus(!unlikeStatus);
        setLikeStatus(false);
        if(unlikeStatus === false && likeStatus === false) {
            setBrojNesvidjanja(brojNesvidjanja +1);
            await customAxios.post("http://localhost:8001/api/reakcija" , {
                svidjanje: false , 
                recenzija_id: item.id
            }); 
        }
        else if(unlikeStatus === true && likeStatus === false){
            setBrojNesvidjanja(brojNesvidjanja - 1);
            await customAxios.delete(`http://localhost:8001/api/reakcija/${item.id}`);
        }
        else if(unlikeStatus === false && likeStatus === true){
            setBrojSvidjanja(brojSvidjanja - 1);
            setBrojNesvidjanja(brojNesvidjanja + 1);
            await customAxios.put("http://localhost:8001/api/reakcija" , {
                id: item.id
            });
        }
    }

  return (
    <div>
        <ButtonGroup toggle>
            <ToggleButton  type='checkbox' variant={likeStatus ? 'success':'outline-success'} onClick={handleLikeClick} style={{marginRight : '10px'}}>
                <FontAwesomeIcon icon={faThumbsUp}/> {brojSvidjanja}
            </ToggleButton>
            <ToggleButton  type='checkbox' variant={unlikeStatus ? 'danger':'outline-danger'} onClick={handleUnlikeClick}>
                <FontAwesomeIcon icon={faThumbsDown}/> {brojNesvidjanja}
            </ToggleButton>
        </ButtonGroup>
    </div>
  )
}

export default Reakcija