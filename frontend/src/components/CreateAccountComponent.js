import React, { Component } from 'react';
import { Control, LocalForm, Form, Errors } from 'react-redux-form';
import { Row, Col, Label, Button, Input } from 'reactstrap';

class CreateAccount extends Component {

    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(values){
        alert(JSON.stringify(values));
    }

    render(){
        return(
            
            <div>
                
                <h3>Register</h3>
                <form onSubmit={(values) => this.handleSubmit(values)}>
                    First Name<input type= "select" name="accounttype"/>
                    <br/>
                    Middle Name (optional) <input type= "text" name= "openingbalance"/>
                    <br/>
                    Last Name<input type= "select" name="accounttype"/>
                    <br/>
                    Username <input type= "text" name= "openingbalance"/>
                    <br/>
                    email <input type= "text" name= "openingbalance"/>
                    <br/>
                    Date of Birth <input type= "text" name= "openingbalance"/>
                    <br/>
                    SSN <input type= "text" name= "openingbalance"/>
                    <br/>
                    <input type ="submit" value= "Create Account"/>

                </form>
            </div>
        );
    }
}

export default CreateAccount