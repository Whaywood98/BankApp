import axios from 'axios';
import * as ActionTypes from './ActionTypes';
import { baseUrlLocal } from '../shared/baseUrl';

export const User = (state = {
    isLoading: true,
    errMess: null,
    firstName: '',
    middleName: '',
    lastName: '',
    userName: '',
    email: '',
    dob: '',
    ssn: null,
    accounts: []
}, action) => {
    switch (action.type) {
        case ActionTypes.ADD_USER:
            return { ...state, isLoading: false, errMess: null, accounts: [], firstName: action.payload.firstName,
                middleName: action.payload.middleName, lastName: action.payload.lastName, userName: action.payload.userName, email: action.payload.email,
                dob: action.payload.dob, ssn: action.payload.ssn }

        case ActionTypes.USER_LOADING:
            return { ...state, isLoading: true, errMess: null, accounts: [], firstName: '',
                middleName: '', lastName: '' } 
        
        case ActionTypes.USER_FAILED:
            return { ...state, isLoading: false, errMess: null, accounts: [], firstName: '',
                middleName: '', lastName: '' }

        default: 
            return state;
    }
}