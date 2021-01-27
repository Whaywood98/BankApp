import React from 'react';
import { Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';
import { SavingsAccountCard, CheckingAccountsCard, CDAccountsCard, PersonalCheckingAccountCard, DBACheckingAccountsCard } from './AccountHomeDisplayComponent';

function Home(props) {

  return(
      <div className="container">
        <h4>Home</h4>
      <div className="col-12 col-md-6 m-1">
        <SavingsAccountCard account={props.savingsAccount} />
      </div>
      <div className="col-12 col-md-6 m-1">
        <CheckingAccountsCard accounts={props.checkingAccounts} />
      </div>
      <div className="col-12 col-md-6 m-1">
        <CDAccountsCard accounts={props.cdAccounts} />
      </div>
      <div className="col-12 col-md-6 m-1">
        <PersonalCheckingAccountCard account={props.personalCheckingAccount} />
      </div>
      <div className="col-12 col-md-6 m-1">
        <DBACheckingAccountsCard accounts={props.dbaCheckingAccount} />
      </div>
      </div>
    );
}

export default Home;   