import axios from 'axios';
import { baseUrlLocal } from '../shared/baseUrl';

class UserServices {

    getUser(){
        return axios.get('http://localhost:8080/Users');
    }

    getUserById(userName){
        return axios.get(baseUrlLocal + '/Users/' + userName);
    }

    postUser(user){
        return axios.post(baseUrlLocal + '/Users', user);
    }
}

export default  new UserServices();