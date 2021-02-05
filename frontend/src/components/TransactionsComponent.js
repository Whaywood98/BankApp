import React, { Component } from 'react';
import { Button } from './ButtonComponent';
import { addUser, deleteCheckingAccount } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import UserServices from '../services/UserServices';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser()),
    deleteCheckingAccount: () => dispatch(deleteCheckingAccount())
});

class Transactions extends Component {
    
    constructor(props){
        super(props)
    }

    deleteAccount = async (event) => {

        const account = () => {
            switch (this.props.match.params.accountType) {
                case 'Checking Accounts':
                    return this.props.user.checkingAccounts;
                case 'Savings Account':
                    return this.props.user.savingsAccount;
                case 'Personal Checking Account':
                    return this.props.user.personalCheckingAccount;
                case 'DBA Checking Account Accounts':
                    return this.props.user.dbaAccounts;
                case 'Certificate of Deposit Accounts':
                    return this.props.user.cdAccounts;
                case 'Regular IRA':
                    return this.props.user.regularIra;
                case 'Rollover IRA':
                    return this.props.user.rolloverIra;
                case 'Roth IRA':
                    return this.props.user.rothIra;
                default:
                    break;
            }
        }
        
        if(Array.isArray(account)){
            for(let acc of account) if (acc.id == this.props.match.params.id) acc = null;
        } else {
            account = null;
        }

        await this.props.dispatch(deleteCheckingAccount(account));
        
        event.preventDefault();
    }

    render(){

        return(
            <>
            <h1>{this.props.match.params.accountType} ID: {this.props.match.params.id}</h1>
            <Button onClick={this.deleteAccount}>Delete Account</Button>
            </>
        );
    }
}

export default withRouter(connect(mapDispatchToProps)(Transactions));