import React, { useState } from 'react'
import Carousel from 'react-bootstrap/Carousel';

function Slider({data}) {
  const [imgIndex , setImgIndex] = useState(0);
  const handleSelect = (selectedIndex , e)=> {
    setImgIndex(selectedIndex);
  }
  return (
    <Carousel activeIndex={imgIndex} onSelect={handleSelect}>
        {
            data?.map((item,index)=>(
            <Carousel.Item key={index} interval={1000}>
            <img src={require(`../assets/${item.putanja}`)} alt='slika nije ucitana' />
            </Carousel.Item>

            ))
               
            
        }
    </Carousel>
  )
}

export default Slider