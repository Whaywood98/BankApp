import React, { Component } from 'react';
import { Button } from './ButtonComponent';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { InitialUserState } from '../shared/InitialUserState';
import { baseUrlLocal } from '../shared/baseUrl';
import axios from 'axios';
import { Card, CardBody } from 'reactstrap';
import'../css/TransactionComp.css';


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
        
            

            const transactions = (this.props.user.transactions != undefined) ? this.props.user.transactions.filter(transaction => 
                                                                                transaction.accountId == this.props.match.params.id): null;
            
                console.log(transactions);

            const transactionCards = (this.props.user.transactions != undefined) ? transactions.map((transaction) => {
                return(
                    <div className= "Transaction-Page-Wrapper">
                
                    <div key={transaction.id}>
                        <Card style={{  position:"relative", padding: '100px' , left: "-180px" ,top: "-20px"  }}>
                            <CardBody>
                                <p className="props-Style" >Type: {transaction.type}</p>
                                <p className="Props-Style">Amount: {transaction.amount}</p>
                                <p className="Props-Style">Processed: {transaction.processed}</p>
                            </CardBody>
                        </Card>
                    </div>
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

                <div className= "Transaction-Page-Wrapper">
                
                <h1 className= "Transaction-title">
                <Card style={{  position:"relative", padding: '150px' , left: "-130px" ,top: "90px"  }}>
                <CardBody style={{  position:"relative" , left: "100px" ,top: "-40px", fontSize:"20px" }} >  
                <p className="props-Style" >{this.props.match.params.accountType}</p>
                <p className="Props-Style">ID: {this.props.match.params.id}</p>
                <p className="Props-Style">Transaction History:</p>
                <p>{transactionCards}</p>
                </CardBody>
                <button onClick={this.deleteToSavingsAccount} type ="submit" class="Btn-1 btn-success" >Close Account</button>
                
                </Card>
            </h1>
        </div>
        </>
                
            );
        } else if(this.props.match.params.accountType == 'Savings Account'){
            return(    
                <>
                 <div className= "Transaction-Page-Wrapper">
                     

                <h1 className= "Transaction-title">  
                <Card style={{  position:"relative", padding: '150px' , left: "-150px" ,top: "90px"  }}>
                <CardBody style={{  position:"relative" , left: "100px" ,top: "-40px", fontSize:"20px" }} >   
                <p className="props-Style" >{this.props.match.params.accountType}</p>
                <p className="Props-Style">ID: {this.props.match.params.id}</p>
                <p className="Props-Style">Transaction History:</p>
                <p>{transactionCards}</p>

                </CardBody>
                <button onClick={ this.deleteUser}type ="submit" class="Btn-1 btn-success">Delete Account</button>
                </Card>

                </h1>
                </div>
                </>
            );
        } else {
            return(
                <>
                <div className= "Transaction-Page-Wrapper">
                <h1 className= "Transaction-Title">
                <Card style={{  position:"relative", padding: '130px' , left: "-100px" ,top: "90px"  }}>
                <CardBody style={{  position:"relative" , left: "100px" ,top: "-40px", fontSize:"20px" }} >  
                <p className="props-Style-1" >{this.props.match.params.accountType}</p>
                <p className="Props-Style">ID: {this.props.match.params.id}</p>
                <p className="Props-Style">Transaction History:</p>
                <p>{transactionCards}</p>
                </CardBody>
                <button onClick={this.deleteToSavingsAccount} type ="submit" class="Btn-2 btn-success">Close To Savings Account</button>
                <button onClick={this.deleteToCheckingAccount} type ="submit" class="Btn-3 btn-success">Close To Personal Checking Account</button>
               </Card>
                </h1>
                </div>
                </>
                
            );
        }
    }
}

export default withRouter(connect(mapDispatchToProps)(Transactions));