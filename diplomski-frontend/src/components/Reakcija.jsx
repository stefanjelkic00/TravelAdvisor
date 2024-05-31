import React, { useState } from 'react'
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