import React, { Component } from 'react';
import { Button } from './ButtonComponent';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { InitialUserState } from '../shared/InitialUserState';
import { baseUrlLocal } from '../shared/baseUrl';
import axios from 'axios';
import { Card, CardBody } from 'reactstrap';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser())
});

class Transactions extends Component {
    
    constructor(props){
        super(props)
    }

    deleteToSavingsAccount = async (event) => {


        const closingTo = 'Savings'


        await axios.patch(baseUrlLocal + '/Users/' + this.props.user.userName + '/' + this.props.match.params.accountType 
                    + '/' + this.props.match.params.id + '/' + closingTo, null, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}});


              axios.get(baseUrlLocal + '/Users/' + this.props.user.userName, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}})
                    .then((response) => this.props.dispatch(addUser(response.data)));
        
        event.preventDefault();
    }

    deleteUser = async (event) => {

        const closingTo = 'Savings'

        await axios.patch(baseUrlLocal + '/Users/' + this.props.user.userName + '/' + this.props.match.params.accountType 
        + '/' + this.props.match.params.id + '/' + closingTo, null, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}});

        this.props.dispatch(addUser(InitialUserState))
        
        event.preventDefault();
    }

    deleteToCheckingAccount = async (event) => {


        const closingTo = 'Checking'


        await axios.patch(baseUrlLocal + '/Users/' + this.props.user.userName + '/' + this.props.match.params.accountType 
                    + '/' + this.props.match.params.id + '/' + closingTo, null, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}});

                    
              axios.get(baseUrlLocal + '/Users/' + this.props.user.userName, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}})
                    .then((response) => this.props.dispatch(addUser(response.data)));
        
        event.preventDefault();
    }

    render(){
        
        
            const transactions = (this.props.user.transactions != undefined) ? this.props.user.transactions.map((transaction) => {
                return(
                    <div key={transaction.id}>
                        <Card>
                            <CardBody>
                                Type: {transaction.type}
                                Amount: {transaction.amount}
                                Processed: {transaction.processed}
                            </CardBody>
                        </Card>
                    </div>
                );
            }):
                    <div>
                        No Transactions
                    </div>
                

        if(this.props.match.params.accountType == 'Checking Accounts' || this.props.match.params.accountType == 'DBA Checking Accounts' ||
        this.props.match.params.accountType == 'Personal Checking Account'){
            return(
                <>
                <h1>{this.props.match.params.accountType} 
                ID: {this.props.match.params.id}
                Transaction History:
                {transactions}
                </h1>
                <Button onClick={this.deleteToSavingsAccount}>Close Account</Button>
                </>
            );
        } else if(this.props.match.params.accountType == 'Savings Account'){
            return(    
                <>
                <h1>{this.props.match.params.accountType} 
                ID: {this.props.match.params.id}
                Transaction History:
                {transactions}
                </h1>
                <Button onClick={this.deleteUser}>Delete Account</Button>
                </>
            );
        } else {
            return(
                <>
                <h1>{this.props.match.params.accountType} 
                ID: {this.props.match.params.id}
                Transaction History:
                {transactions}
                </h1>
                <Button onClick={this.deleteToSavingsAccount}>Close to Savings Account</Button>
                <Button onClick={this.deleteToCheckingAccount}>Close to Personal Checking Account</Button>
                </>
            );
        }
    }
}

export default withRouter(connect(mapDispatchToProps)(Transactions));