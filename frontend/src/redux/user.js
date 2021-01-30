import * as ActionTypes from './ActionTypes';

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
            return { ...state, isLoading: false, errMess: null, accounts: [], firstName: action.payload[0].firstName,
                middleName: action.payload[0].middleName, lastName: action.payload[0].lastName}

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