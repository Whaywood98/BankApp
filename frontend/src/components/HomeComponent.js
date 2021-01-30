import React from 'react'
import HomeSection from './HomeSectionComponent';
import {homeObjOne} from '../shared/data';
import { SavingsAccountCard, CheckingAccountsCard, CDAccountsCard, PersonalCheckingAccountCard, DBACheckingAccountsCard, UserCard } from './AccountCardsComponent';

function Home(props) {

    


    return (
        <>
        <div className="col-12 col-md-6 m-1">
          <UserCard user={props.user} />
        </div>
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
        <HomeSection {...homeObjOne} />
        
        
        </>

    );
}
export default Home; 