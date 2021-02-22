import React from 'react';
import {Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';
import '../css/AccountSummary.css';

function AccountSummaryCard(props) {
        return(
        <>

        <div className= "Account-Summary-Wrapper">
        <Link to={`/transactions/${props.accountType}/${props.account.id}`} style={{ textDecoration: 'none' }}>
            
        <Card style={{ position:"relative", padding: '50px' , left: "-150px" ,top: "-30px"  }}>
                <CardTitle style={{ width:"250px",  position:"relative", padding: '90px' , left: "-20px" ,top: "-100px", fontSize:"27px" }}> Account Summary</CardTitle>
                <CardBody style={{  position:"center" , left: "100px" ,marginTop: "-150px", fontSize:"20px" }} >
                    <p className="Props-Style">{props.accountType}</p>
                    <p className="Props-Style">ID: {props.account.id}</p>
                    <p className="Props-Style">Balance: {props.account.balance}</p>
                    <p className="Props-Style">Interest Rate: {props.account.interestRate}</p>
                </CardBody>
            </Card>
        </Link>
        </div>
        </>
        );     
}

const AccountSummary = (props) => {
    if(Array.isArray(props.accounts)){
        const summary = props.accounts.map((account) => {
            return(
                <div key={account.id}>
                    <AccountSummaryCard  account={account} accountType={props.accountType} />
                </div>
            )
        })
        return(
        <>
       
            <Link to={`/transactions/${props.accountType}`} style={{ textDecoration: 'none' }}>
                <p>{summary}</p>
            </Link>
        </>
        );
    } else {
        return(
            <>
                
                <p><AccountSummaryCard style={{  position:"relative", padding: '100px' , left: "-180px" ,top: "-550px"  }} account={props.accounts} accountType={props.accountType} /></p>
            </>
        );
    }
}

export default AccountSummary