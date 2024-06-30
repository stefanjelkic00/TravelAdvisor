import { Form, Formik } from 'formik'
import React from 'react'
import TextField from '../../components/TextField'
import SigninImage from '../../assets/login2.jpg'
import * as Yup from 'yup'
import customAxios from '../../utils/customAxios'
import {toast} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"
import { useNavigate } from 'react-router-dom'

function Login() {

    const navigate = useNavigate();

  const validate = Yup.object({
    email : Yup.string().email("Email is not valid").required("Email is required .") , 
    password : Yup.string().matches(/(?=.*[a-z])/ , "One lower case required .")
            .matches( /(?=.*[A-Z])/ , "One upprer case required .")
            .matches(/(?=.*[0-9])/ , "One number required .")
            .min(5 , "Password must be at least 5 characters .")
            .required("Password is required . ")
  });
  
  return (
    <div className='d-flex flex-row justify-content-center align-items-center p-5 ' style={{minHeight:"78.8vh"}}>  
        <div className='col-md-5'>
            <Formik 
                initialValues={{
                    email: "" , 
                    password: ""
                }}
                validationSchema={validate}
                onSubmit={
                    async(values)=> {
                        try {
                            await customAxios.get("http://localhost:8001/api/login" , {
                                params : {
                                    email : values.email , 
                                    password : values.password 
                                }
                            }).then(response => {
                                sessionStorage.setItem("jwtToken" , response.data.jwtToken );
                                sessionStorage.setItem("email" , response.data.email);
                                toast.success("Uspesno ste se ulogovali ." );
                                setTimeout(() => {
                                    navigate("/");
                                }, 500);  
                            } );
                        } catch (error) {
                            toast.error("Neispravni podaci , pokusajte ponovo ." );    
                        }  
                    }
                }
            > 
                {formik => (
                    <div>
                    <h1 className='my-4 font-weight-bold-display-4'>Prijava :</h1>
                    <Form>
                        <TextField label="Email :" name="email" type="email"/>
                        <TextField label="Šifra :" name="password" type="password"/>
                        <button className='btn btn-primary mt-3 me-3' type="submit">Prijava</button>
                    </Form>
                </div>
                )}
            </Formik>
        </div>
        <div className='col-md-5 my-auto' style={{width:"10rem" , marginLeft:"50px" , paddingTop:"50px"}} >
            <img  className='img-fluid w-100' src={SigninImage}  alt="SignIn" />
        </div>
    </div>
  )
}

export default Login