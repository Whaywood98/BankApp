import React, { Component } from 'react';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import UserServices from '../services/UserServices';
import { Button } from './ButtonComponent';
import {Link} from 'react-router-dom'
import { Card, CardTitle, CardBody } from 'reactstrap';
import { InitialUserState } from '../shared/InitialUserState';


const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser())
});

class MyProfile extends Component {

    constructor(props){
        super(props);

    }

    logout = (event) => {
        event.preventDefault();
        this.props.dispatch(addUser(InitialUserState));
    }

    render(){
       return(
        <>
            <Card>
                <CardTitle>{this.props.user.userName}</CardTitle>
                <CardBody>
                    <p>{this.props.user.dob}</p>
                    <p>{this.props.user.ssn}</p>
                </CardBody>
            </Card>
            <Link to="/home">
                <Button onClick={this.logout}>Logout</Button>
            </Link>
        </>
       );
    }
}

export default withRouter(connect(mapDispatchToProps)(MyProfile));