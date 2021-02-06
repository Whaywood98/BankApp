import React, { Component } from 'react';
import { Button } from './ButtonComponent';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import UserServices from '../services/UserServices';
import { InitialUserState } from '../shared/InitialUserState';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser())
});

class Transactions extends Component {
    
    constructor(props){
        super(props)
    }

    deleteToSavingsAccount = async (event) => {
        const closingTo = 'Savings'
        await UserServices.deleteAccount(this.props.user.userName, this.props.match.params.accountType, this.props.match.params.id, closingTo);
        UserServices.getUserById(this.props.user.userName)
            .then((response) => this.props.dispatch(addUser(response.data)));
        
        event.preventDefault();
    }

    deleteUser = async (event) => {
        const closingTo = 'Savings'
        await UserServices.deleteAccount(this.props.user.userName, this.props.match.params.accountType, this.props.match.params.id, closingTo);
        this.props.dispatch(addUser(InitialUserState))
        
        event.preventDefault();
    }

    deleteToCheckingAccount = async (event) => {
        const closingTo = 'Checking'
        await UserServices.deleteAccount(this.props.user.userName, this.props.match.params.accountType, this.props.match.params.id, closingTo);
        UserServices.getUserById(this.props.user.userName)
            .then((response) => this.props.dispatch(addUser(response.data)));
        
        event.preventDefault();
    }

    render(){
        if(this.props.match.params.accountType == 'Checking Accounts' || this.props.match.params.accountType == 'DBA Checking Accounts' ||
        this.props.match.params.accountType == 'Personal Checking Account'){
            return(
                <>
                <h1>{this.props.match.params.accountType} ID: {this.props.match.params.id}</h1>
                <Button onClick={this.deleteToSavingsAccount}>Close Account</Button>
                </>
            );
        } else if(this.props.match.params.accountType == 'Savings Account'){
            return(    
                <>
                <h1>{this.props.match.params.accountType} ID: {this.props.match.params.id}</h1>
                <Button onClick={this.deleteUser}>Delete Account</Button>
                </>
            );
        } else {
            return(
                <>
                <h1>{this.props.match.params.accountType} ID: {this.props.match.params.id}</h1>
                <Button onClick={this.deleteToSavingsAccount}>Close to Savings Account</Button>
                <Button onClick={this.deleteToCheckingAccount}>Close to Personal Checking Account</Button>
                </>
            );
        }
    }
}

export default withRouter(connect(mapDispatchToProps)(Transactions));