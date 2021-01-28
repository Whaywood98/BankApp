import axios from 'axios';
import baseUrlLocal from '../shared/baseUrl';

class UserService {

    getUser(){
        return axios.get(baseUrlLocal + '/user');
    }
}