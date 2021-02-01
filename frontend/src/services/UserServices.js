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

    postAccount(accountType, userName, data){
        return axios.post(baseUrlLocal + '/Users/' + userName + '/' + accountType, data);
    }
}

export default  new UserServices();