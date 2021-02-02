import React, { Component } from 'react';
import { Control, LocalForm, Form, Errors } from 'react-redux-form';
import { Row, Col, Label, Button, Input } from 'reactstrap';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { baseUrlLocal } from '../shared/baseUrl';
import UserServices from '../services/UserServices';


const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser()),
});

class CreateAccount extends Component {

    constructor(props){
        super(props);
        this.state = {
            accountType: 'Checking Account',
            balance: null,
            interestRate: null
            
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit = (event) => {
        event.preventDefault();
        const data = this.state;
        UserServices.postAccount(this.state.accountType, this.props.user.userName, data);
        UserServices.getUserById(this.props.user.userName)
            .then((response) => this.props.dispatch(addUser(response.data)));
    }

    handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render(){
        return(
            
            <div>
                
                <h3>Register</h3>
                <form onSubmit={this.handleSubmit}>
                    Account Type: <select name="accountType" onChange={this.handleInputChange}>
                                    <option onClick={this.setAccountType}>Checking Account</option>
                                    <option onClick={this.setAccountType}>Savings Account</option> 
                                    <option onClick={this.setAccountType}>Personal Checking Account</option> 
                                    <option onClick={this.setAccountType}>DBA Checking Account</option> 
                                    <option onClick={this.setAccountType}>Certificate of Deposit Account</option> 
                                    <option onClick={this.setAccountType}>Regular IRA</option> 
                                    <option onClick={this.setAccountType}>Rollover IRA</option> 
                                    <option onClick={this.setAccountType}>Roth IRA</option> 
                                    </select>
                    <br/>
                    Opening Balance: <input type= "text" name= "balance" onChange={this.handleInputChange}/>
                    <br/>
                    Interest Rate: <input type= "select" name="interestRate" onChange={this.handleInputChange}/>
                    <br/>
                    <input type ="submit" value= "Create Account" />

                </form>
            </div>
        );
    }
}

export default withRouter(connect(mapDispatchToProps)(CreateAccount));