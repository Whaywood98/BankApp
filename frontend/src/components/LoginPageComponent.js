import axios from 'axios';
import React from 'react';
import'../css/LoginPage.css';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { baseUrlLocal } from '../shared/baseUrl';
import UserServices from '../services/UserServices';
import {MdFingerprint} from 'react-icons/md';




const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser()),
});


class LoginPage extends React.Component {




     constructor(props) {
         super(props);
         this.state = {
             err: '',
             userName: '',
             password: ''
         };


    }


     handleSubmit = (event) =>{
        event.preventDefault();
        const user = this.state.userName
        UserServices.getUserById(user)
            .then((response) => this.props.dispatch(addUser(response.data)));
     }


     handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }


    render() {


        let format = {
        color: "red"
        };
        return (
        
           <html>
               <body class="login-Wrapper">
            
            
                 <div class="login-container">
                 <h1> User Login</h1>
                 
                 
                <span style={format}>{this.state.err != '' ? this.state.err : ''}</span>
                <form onSubmit={this.handleSubmit}>

                <div class= "input-div">
                    
                    <h2> Username </h2> <input class= "Input-Box" type= "text" name="userName" onChange={this.handleInputChange}/>
                    <br/>
                   
                    <h2> Password </h2> <input class= "Input-Box"  type="password" name= "password" onChange={this.handleInputChange}/>
                    <br/>
                    <button type ="submit" class="btn btn-success">Login</button>

                    
                </div>
                </form>
                </div>
                </body>
                </html>
               
                
               
                
            
        )
    }


}


export default withRouter(connect(mapDispatchToProps)(LoginPage));

