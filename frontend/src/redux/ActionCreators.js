import * as ActionTypes from './ActionTypes';
import { SAVINGS_ACCOUNT } from '../shared/savingsAccount';
import { CHECKING_ACCOUNTS } from '../shared/checkingAccounts';
import { CDACCOUNTS } from '../shared/cdAccounts';
import { PERSONAL_CHECKING_ACCOUNT } from '../shared/personalCheckingAccount';
import { DBA_CHECKING_ACCOUNTS } from '../shared/dbaCheckingAccounts';
import { IRA } from '../shared/ira';
import baseUrl from '../shared/baseUrl';
import UserServices from '../services/UserServices';


export const fetchUser = () => (dispatch) => {
    dispatch(userLoading(true));

    UserServices.getUser()
            .then((response) => dispatch(addUser(response.data)))
            .catch(error => dispatch(userFailed(error.message)));
    
}

export const fetchSavingsAccount = () => (dispatch) => {
    
    dispatch(savingsAccountLoading(true));

    dispatch(addSavingsAccount(SAVINGS_ACCOUNT));
}

export const fetchCheckingAccounts = () => (dispatch) => {
    
    dispatch(checkingAccountLoading(true));

    dispatch(addCheckingAccount(CHECKING_ACCOUNTS));
}

export const fetchCdAccounts = () => (dispatch) => {
    
    dispatch(cdAccountLoading(true));

    dispatch(addCdAccount(CDACCOUNTS));
}

export const fetchPersonalCheckingAccount = () => (dispatch) => {
    
    dispatch(personalCheckingAccountLoading(true));

    dispatch(addPersonalCheckingAccount(PERSONAL_CHECKING_ACCOUNT));
}

export const fetchDbaCheckingAccounts = () => (dispatch) => {
    
    dispatch(dbaCheckingAccountLoading(true));

    dispatch(addDbaCheckingAccount(DBA_CHECKING_ACCOUNTS));
}

export const userFailed = (errmess) => ({
    type: ActionTypes.USER_FAILED,
    payload: errmess
})

export const savingsAccountFailed = (errmess) => ({
    type: ActionTypes.SAVINGS_ACCOUNT_FAILED,
    payload: errmess
})
export const checkingAccountsFailed = (errmess) => ({
    type: ActionTypes.CHECKING_ACCOUNTS_FAILED,
    payload: errmess
})
export const cdAccountsFailed = (errmess) => ({
    type: ActionTypes.CDACCOUNT_FAILED,
    payload: errmess
})
export const personalCheckingAccountFailed = (errmess) => ({
    type: ActionTypes.PERSONAL_CHECKING_ACCOUNT_FAILED,
    payload: errmess
})
export const dbaCheckingAccountsFailed = (errmess) => ({
    type: ActionTypes.DBA_CHECKING_ACCOUNT_FAILED,
    payload: errmess
})

export const addUser = (user) => ({
    type: ActionTypes.ADD_USER,
    payload: user
})

export const addSavingsAccount  = (account) => ({
    type: ActionTypes.ADD_SAVINGS_ACCOUNT,
    payload: account
})

export const addCheckingAccount  = (accounts) => ({
    type: ActionTypes.ADD_CHECKING_ACCOUNTS,
    payload: accounts
})

export const addCdAccount  = (accounts) => ({
    type: ActionTypes.ADD_CDACCOUNT,
    payload: accounts
})

export const addPersonalCheckingAccount  = (accounts) => ({
    type: ActionTypes.ADD_PERSONAL_CHECKING_ACCOUNT,
    payload: accounts
})

export const addDbaCheckingAccount  = (accounts) => ({
    type: ActionTypes.ADD_DBA_CHECKING_ACCOUNT,
    payload: accounts
})

export const userLoading = () => ({
    type: ActionTypes.USER_LOADING
})

export const savingsAccountLoading = () => ({
    type: ActionTypes.SAVINGS_ACCOUNT_LOADING
})

export const checkingAccountLoading = () => ({
    type: ActionTypes.CHECKING_ACCOUNTS_LOADING
})

export const cdAccountLoading = () => ({
    type: ActionTypes.CDACCOUNT_LOADING
})

export const personalCheckingAccountLoading = () => ({
    type: ActionTypes.PERSONAL_CHECKING_ACCOUNT_LOADING
})

export const dbaCheckingAccountLoading = () => ({
    type: ActionTypes.DBA_CHECKING_ACCOUNT_LOADING
})