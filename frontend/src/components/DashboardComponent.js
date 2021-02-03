import React from 'react'
import HomeSection from './HomeSectionComponent';
import { SavingsAccountCard, CheckingAccountsCard, CDAccountsCard, PersonalCheckingAccountCard, DBACheckingAccountsCard, UserCard,
          RegularIraCard, RolloverIraCard, RothIraCard } from './AccountCardsComponent';

function Dashboard(props) {
    return (
        <>
        <div className="col-12 col-md-6 m-1">
          <UserCard user={props.user} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <SavingsAccountCard account={props.user.savingsAccount} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <CheckingAccountsCard accounts={props.user.checkingAccounts} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <CDAccountsCard accounts={props.user.cdAccounts} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <PersonalCheckingAccountCard account={props.user.personalCheckingAccount} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <DBACheckingAccountsCard accounts={props.user.dbaAccounts} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <RegularIraCard account={props.user.regularIra} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <RolloverIraCard account={props.user.rolloverIra} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <RothIraCard account={props.user.rothIra} />
        </div>
        </>
    );
}
export default Dashboard; 