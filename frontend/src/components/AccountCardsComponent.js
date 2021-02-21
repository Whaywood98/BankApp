import React from 'react';
import { Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';
import'../css/AccountsCard.css';

function getCummulativeBalance(accounts){

    var cummulativeBalance;
    cummulativeBalance = accounts.reduce(function(tot, arr) {  
        return tot + arr.balance;
    }, 0);
    return cummulativeBalance;
}

export const UserCard = ({ user }) => {
    return(

        
        <Card  style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/myprofile" style={{ textDecoration: 'none' , color: '#00b894' }}>
            <CardTitle>{user.firstName} {user.lastName}'s Profile Info</CardTitle>
            </Link>
        </Card>
    )
}

export const SavingsAccountCard = ({ account }) => {
    if(account != null)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}>
            < Link to="/accountsummary/savings"  style={{ textDecoration: 'none', color: '#00b894'  }}>
            <CardTitle>Savings Account</CardTitle>
            <CardBody style={{color:"#5e6665"}}>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount"  style={{ textDecoration: 'none' , color: '#00b894' }}>
                <CardTitle>Create Savings Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const CheckingAccountsCard = (accounts) => {
    if(accounts.accounts.length != 0)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/accountsummary/checking"  style={{ textDecoration: 'none' , color: '#00b894' }}>
            <CardTitle>Checking Accounts</CardTitle>
            <CardBody style={{color:"#5e6665"}}>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount" style={{ textDecoration: 'none', color: '#00b894' }}>
                <CardTitle>Create Checking Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const CDAccountsCard = (accounts) => {
    if(accounts.accounts.length != 0)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/accountsummary/cd"  style={{ textDecoration: 'none' , color: '#00b894' }}>
            <CardTitle >Certificate of Deposit Accounts</CardTitle>
            <CardBody style={{color:"#5e6665"}}>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount"  style={{ textDecoration: 'none' , color: '#00b894' }} >
                <CardTitle>Create Certificate of Deposit Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const PersonalCheckingAccountCard = ({ account }) => {
    if(account != null)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/accountsummary/personal"  style={{ textDecoration: 'none' , color: '#00b894' }}>
            <CardTitle>Personal Checking Account</CardTitle>
            <CardBody style={{color:"#5e6665"}}>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount"style={{ textDecoration: 'none' , color: '#00b894' }}>
                <CardTitle>Create Personal Checking Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const DBACheckingAccountsCard = (accounts) => {
    if(accounts.accounts.length != 0)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/accountsummary/dba" style={{ textDecoration: 'none', color: '#00b894' }}>
            <CardTitle>DBA Checking Accounts</CardTitle>
            <CardBody style={{color:"#5e6665"}}>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount"  style={{ textDecoration: 'none' , color: '#00b894'}}>
                <CardTitle>Create DBA Checking Account?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const RegularIraCard = ({ account }) => {
    if(account != null)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/accountsummary/regular"  style={{ textDecoration: 'none' , color: '#00b894' }} >
            <CardTitle>Regular IRA</CardTitle>
            <CardBody style={{color:"#5e6665"}}>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount"  style={{ textDecoration: 'none' , color: '#00b894' }}>
                <CardTitle>Create Regular IRA?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const RolloverIraCard = ({ account }) => {
    if(account != null)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/accountsummary/rollover"  style={{ textDecoration: 'none', color: '#00b894' }}>
            <CardTitle>Rollover IRA</CardTitle>
            <CardBody style={{color:"#5e6665"}}> Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount"  style={{ textDecoration: 'none' , color: '#00b894' }}>
                <CardTitle>Create Rollover IRA?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const RothIraCard = ({ account }) => {
    if(account != null)
    return(
        <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
            <Link to="/accountsummary/roth" style={{ textDecoration: 'none',  color: '#00b894' }}>
            <CardTitle>Roth IRA</CardTitle>
            <CardBody style={{color:"#5e6665"}}>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card style={{width:"50%", height:"80%", padding: '40px', left: "-200px", position:"relative", left: "-50px" }}> 
                <Link to="/createaccount"  style={{ textDecoration: 'none' , color: '#00b894'}}>
                <CardTitle>Create Roth IRA?</CardTitle>
                </Link>
            </Card>
            
        )
    }
}