import React, { useEffect, useState } from 'react';
import {MapContainer , TileLayer , Marker , Popup } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import icon from "../assets/mapaikonica.jpg";
import L from "leaflet";


function Map({item}) {
    const [position , setPosition] = useState(null);
    const mapIcon = L.icon({
        iconUrl: icon , 
        iconSize: [25,25]
    })
    useEffect(()=>{
        if(item !== undefined){
            setPosition([item.latitude , item.longitude]);
        }
       
    },[item]);
  return (
    <>
    {
        position && 
        <MapContainer center={position} zoom={15} style={{height:"350px" , width:"60%" }}>
            <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>
            <Marker position={position} icon={mapIcon}>
                <Popup>
                    {item.naziv}
                    <br/>
                    {item.adresa}
                </Popup>
            </Marker>
        </MapContainer>
    }
    </>
             
  )
}

export default Map