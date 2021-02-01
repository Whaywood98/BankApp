import React from 'react';
import {Card, CardTitle, CardBody } from 'reactstrap';

function AccountSummaryCard(props) {
        return(
        <div>
            <Card>
                <CardTitle>Summary</CardTitle>
                <CardBody>
                    <p>ID: {props.account.id}</p>
                    <p>Balance: {props.account.balance}</p>
                    <p>Interest Rate: {props.account.interestRate}</p>
                </CardBody>
            </Card>
        </div>
        );     
}

const AccountSummary = (props) => {
    if(props.accounts == null || props.accounts.length === 0)
    return(
        <div>
            <h1>Whoops! ...</h1>
            <p>Nothing was found for {props.accountType}</p>
        </div>
    );
    else{
        const summary = props.accounts.map((account) => {
            return(
                <div key={account.id}>
                    <AccountSummaryCard account={account} />
                </div>
            )
        })
        return(
        <div>
            <p>{props.accountType}</p>
            <p>{summary}</p>
        </div>
        );
    }
}

export default AccountSummary