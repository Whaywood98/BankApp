import axios from 'axios';
import { baseUrlLocal } from '../shared/baseUrl';

class UserServices {

    getUser(){
        return axios.get('http://localhost:8080/users');
    }

    postUser({ user }){
        return axios.post(baseUrlLocal + '/users', user);
    }
}

export default  new UserServices();