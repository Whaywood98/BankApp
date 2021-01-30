import React, { Component } from 'react';
import { Control, LocalForm, Form, Errors } from 'react-redux-form';
import { Row, Col, Label, Button, Input } from 'reactstrap';
import { postUser } from '../redux/ActionCreators';

class CreateUser extends Component {

    constructor(props){
        super(props);
        this.state = {
            firstName: '',
            middleName: '',
            lastName: '',
            userName: '',
            email: '',
            accountOpened: new Date(),
            dob: '',
            ssn: null
        }
    }

    handleSubmit = (event) => {
        event.preventDefault()
        const data = this.state
        data.dob = new Date(data.dob);
        postUser(data);
        alert(JSON.stringify(data));
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
                    First Name: <input type= "select" name="firstName" onChange={this.handleInputChange}/>
                    <br/>
                    Middle Name: (optional) <input type= "text" name= "middleName" onChange={this.handleInputChange}/>
                    <br/>
                    Last Name: <input type= "select" name="lastName" onChange={this.handleInputChange}/>
                    <br/>
                    Username: <input type= "text" name= "userName" onChange={this.handleInputChange}/>
                    <br/>
                    Email: <input type= "text" name= "email" onChange={this.handleInputChange}/>
                    <br/>
                    Date of Birth: <input type= "text" name= "dob" onChange={this.handleInputChange}/>
                    <br/>
                    SSN: <input type= "text" name= "ssn" onChange={this.handleInputChange}/>
                    <br/>
                    <input type ="submit" value= "Create Account" onChange={this.handleInputChange}/>

                </form>
            </div>
        );
    }
}

export default CreateUser