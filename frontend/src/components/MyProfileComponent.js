import React, { Component } from 'react';
import { addUser, deleteToken } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { Button } from './ButtonComponent';
import {Link} from 'react-router-dom'
import { Card, CardTitle, CardBody } from 'reactstrap';
import { InitialUserState } from '../shared/InitialUserState';
import UserServices from '../services/UserServices';
import axios from 'axios';
import { baseUrlLocal } from '../shared/baseUrl';
import'../css/MyProfile.css';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser()),
    deleteToken: () => dispatch(deleteToken())
});

class MyProfile extends Component {

    
    constructor(props){
        super(props);
        

    }

    logout = (event) => {
        event.preventDefault();
        this.props.dispatch(addUser(InitialUserState));
        this.props.dispatch(deleteToken);
    }

    deleteAccount = (event) => {
        event.preventDefault();
        axios.delete(baseUrlLocal + '/Users/' + this.props.user.userName, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}});
        this.props.dispatch(addUser(InitialUserState));
    }

    render(){
        if(this.props.user.userName.length != 0)
        return(
            <>
            <div class= "My-Profile-Wrapper">
                <Card style={{  position:"relative", padding: '100px' , left: "-70px" ,top: "-60px"  }}>
                    <CardTitle style={{position:"relative" , left: "10px" ,top: "-80px", fontSize:"27px"  }}> My Profile Information</CardTitle>
                    <CardBody>
                        <p className= "prop-style">{this.props.user.userName}</p>
                        <p className= "prop-style">{this.props.user.dob}</p>
                        <p className= "prop-style">{this.props.user.ssn}</p>
                    </CardBody>
                </Card>
                <Link to="/" >
                    <button onClick={this.logout} type ="submit" class="btn-1 btn-success" >Logout</button>
                </Link>
                <button onClick={this.deleteAccount} type ="submit" class="btn-1 btn-success">Delete Profile</button>
                </div>
            </>
            
        );
        else{
            return(
                <div  class = "Dashboard-wrapper">
                    <Link to="/home">
                        <Button>Sign Up</Button>
                    </Link>
                </div>
                
            );
        }
    }
}

export default withRouter(connect(mapDispatchToProps)(MyProfile));