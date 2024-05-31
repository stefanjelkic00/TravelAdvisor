import React from 'react'
import { Formik , Form } from 'formik'
import SigninImage from '../../assets/login2.jpg'
import TextField from '../../components/TextField'
import * as Yup from 'yup'
import {toast} from "react-toastify"
import "react-toastify/dist/ReactToastify.css"
import customAxios from '../../utils/customAxios'
import { useNavigate } from 'react-router-dom'

function Registration() {

    const navigate = useNavigate();
    const validate = Yup.object({
        name : Yup.string().min(3 , "Name must have at least 3 characters .")
            .max(10 , "Name can have 10 characters maximum .")
            .required("Name is required") , 
        surname : Yup.string().min(3 , "Surname must have at least 3 characters .")
            .max(10 , "Surname can have 10 characters maximum .")
            .required("Surname is required"),
        email : Yup.string().email("Email is not valid").required("Email is required .") , 
        password : Yup.string().matches(/(?=.*[a-z])/ , "One lower case required .")
                .matches( /(?=.*[A-Z])/ , "One upprer case required .")
                .matches(/(?=.*[0-9])/ , "One number required .")
                .min(5 , "Password must be at least 5 characters .")
                .required("Password is required . "), 
        confirmPassword : Yup.string().oneOf([Yup.ref("password"), null] , "Passwords dont match .")
            .required("confirmPassword is required")
      });
  return (
        <div className='d-flex flex-row justify-content-center align-items-center p-5 ' style={{minHeight:"78.8vh"}}>  
            <div className='col-md-5'>
                <Formik
                    initialValues={{
                        name: "",
                        surname: "", 
                        email: "", 
                        password: "", 
                        confirmPassword: ""
                    }}
                    validationSchema={validate}
                    onSubmit={
                        async(values)=> {
                            try{
                                await customAxios.post("http://localhost:8001/api/register" , {
                                    ime: values.name , 
                                    prezime : values.surname , 
                                    email : values.email , 
                                    password : values.password
                                });
                                toast.success("Korisnik se uspesno registrovao .");
                                setTimeout(() => {
                                    navigate("/login");
                                }, 500);
                            }catch(error){
                                toast.error("Niste uneli ispravne podatke za registraciju , pokusajte ponovo .");
                            }

                        }
                    }
                > 
                    {formik => (
                        
                        <div>
                        <h1 className='my-4 font-weight-bold-display-4'>Registration form </h1>
                        <Form>
                            <TextField label="Name :" name="name" type="text"/>
                            <TextField label="Surname :" name="surname" type="text"/>
                            <TextField label="Email :" name="email" type="email"/>
                            <TextField label="Password :" name="password" type="password"/>
                            <TextField label="Confirm password :" name="confirmPassword" type="password"/>
                            <button className='btn btn-primary mt-3 me-3' type="submit">Register</button>
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

export default Registration