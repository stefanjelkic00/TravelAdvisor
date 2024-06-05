import React, {useState } from 'react'
import { ButtonGroup, ToggleButton } from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome' 
import {faThumbsUp , faThumbsDown} from '@fortawesome/free-solid-svg-icons';

function ReakcijaNoAuth({item , index}) {
   
    const [brojSvidjanja , setBrojSvidjanja] = useState(item.brojSvidjanja);
    const [brojNesvidjanja , setBrojNesvidjanja] = useState(item.brojNesvidjanja);
  return (
    <div>
        <ButtonGroup toggle>
            <ToggleButton  type='checkbox' variant='outline-success' style={{marginRight : '10px'}}>
                <FontAwesomeIcon icon={faThumbsUp}/> {brojSvidjanja}
            </ToggleButton>
            <ToggleButton  type='checkbox' variant='outline-danger' >
                <FontAwesomeIcon icon={faThumbsDown}/> {brojNesvidjanja}
            </ToggleButton>
        </ButtonGroup>
    </div>
  )
}

export default ReakcijaNoAuth