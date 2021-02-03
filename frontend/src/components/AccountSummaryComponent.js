import React from 'react';
import {Card, CardTitle, CardBody } from 'reactstrap';

function AccountSummaryCard(props) {
        return(
        <>
            <Card>
                <CardTitle>Summary</CardTitle>
                <CardBody>
                    <p>ID: {props.account.id}</p>
                    <p>Balance: {props.account.balance}</p>
                    <p>Interest Rate: {props.account.interestRate}</p>
                </CardBody>
            </Card>
        </>
        );     
}

const AccountSummary = (props) => {
    if(Array.isArray(props.accounts)){
        const summary = props.accounts.map((account) => {
            return(
                <div key={account.id}>
                    <AccountSummaryCard account={account} />
                </div>
            )
        })
        return(
        <>
            <p>{props.accountType}</p>
            <p>{summary}</p>
        </>
        );
    } else {
        return(
            <>
                <p>{props.accountType}</p>
                <p><AccountSummaryCard account={props.accounts} /></p>
            </>
        );
    }
}

export default AccountSummary