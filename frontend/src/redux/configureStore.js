import { SavingsAccount } from './savingsAccount';
import { CheckingAccounts } from './checkingAccounts';
import { CDAccounts } from './cdAccounts';
import { PersonalCheckingAccount } from './personalCheckingAccount';
import { DBACheckingAccounts } from './dbaCheckingAccounts';
import { createStore, combineReducers, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';

export const ConfigureStore = () => {
    const store = createStore(
        combineReducers({
            savingsAccount: SavingsAccount,
            checkingAccounts: CheckingAccounts,
            cdAccounts: CDAccounts,
            personalCheckingAccount: PersonalCheckingAccount,
            dbaCheckingAccount: DBACheckingAccounts
        }),
        applyMiddleware(thunk, logger)
    );
    return store;
}