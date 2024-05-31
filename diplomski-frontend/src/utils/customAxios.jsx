import axios from "axios";

const customAxios = axios.create();

customAxios.interceptors.request.use(
    (config) => {
        const token = sessionStorage.getItem("jwtToken");
        console.log(token);
        return{
            ...config , 
            headers: {
                ...(token !== null && {Authorization: `Bearer ${token}`}),
                ...config.headers
            }
        }
    },
    (error)=>{
        return Promise.reject(error);
    }
);

export default customAxios;
