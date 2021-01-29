import React from 'react';
import { Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';

function getCummulativeBalance(accounts){

    var cummulativeBalance;
    cummulativeBalance = accounts.reduce(function(tot, arr) {
            return tot + arr.balance;
    }, 0);
    return cummulativeBalance;
}

export const UserCard = (user) => {
    return(
        <Card>
            <Link to="/userprofile">
            <CardTitle>{user.firstName}</CardTitle>
            </Link>
        </Card>
    )
}

export const SavingsAccountCard = ({ account }) => {
    if(JSON.stringify(account) != '{}')
    return(
        <Card>
            <Link to="/savingsaccount">
            <CardTitle>Savings Account</CardTitle>
            <CardBody>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount">
                <CardTitle>Create Savings Account?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const CheckingAccountsCard = (accounts) => {
    if(accounts.accounts.length)
    return(
        <Card>
            <Link to="/checkingaccounts">
            <CardTitle>Checking Accounts</CardTitle>
            <CardBody>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount">
                <CardTitle>Create Checking Account?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const CDAccountsCard = (accounts) => {
    if(accounts.accounts.length)
    return(
        <Card>
            <Link to="cdAccounts">
            <CardTitle>Certificate of Deposit Accounts</CardTitle>
            <CardBody>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount">
                <CardTitle>Create Certificate of Deposit Account?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const PersonalCheckingAccountCard = ({ account }) => {
    if(JSON.stringify(account) != '{}')
    return(
        <Card>
            <Link to="personalcheckingaccount">
            <CardTitle>Personal Checking Account</CardTitle>
            <CardBody>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount">
                <CardTitle>Create Personal Checking Account?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const DBACheckingAccountsCard = (accounts) => {
    if(accounts.accounts.length)
    return(
        <Card>
            <Link to="dbacheckingaccounts">
            <CardTitle>DBA Checking Accounts</CardTitle>
            <CardBody>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount">
                <CardTitle>Create DBA Checking Account?</CardTitle>
                </Link>
            </Card>
        )
    }
}