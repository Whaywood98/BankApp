import React, { Component } from 'react';
import { Control, LocalForm, Form, Errors } from 'react-redux-form';
import { Row, Col, Label, Button, Input } from 'reactstrap';

class CreateUser extends Component {

    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(values){
        alert(JSON.stringify(values));
    }

    render(){
        return(
            <div className="container">
                <Form>
                    <h1>Register User</h1>
                    <Row className="form-group">
                    <Label htmlFor="accounttype">Account Type:</Label>
                    <Col md={5}>
                        <Input type="text" className="form-control" id="firstName" innerRef={(input) => this.accounttype = input} />
                    </Col>
                    </Row>
                    <Row className="form-group">
                    <Label htmlFor="balance">Opening Balance</Label>
                    <Col md={5}>
                        <Input type="text" className="form-control" id="balance" placeholder="Opening Balance" innerRef={(input) => this.balance = input}/>
                    </Col>
                    </Row>
                    <Row className="form-group">
                        <Col>
                            <Button type="submit" color="primary" onSubmit={(values) => this.handleSubmit(values)}>
                                Register
                            </Button>
                        </Col>
                    </Row>
                </Form>
            </div>
        );
    }
}

export default CreateUser