// import React, { Component } from 'react';
// import { Control, LocalForm, Form, Errors } from 'react-redux-form';
// import { Row, Col, Label, Button, Input } from 'reactstrap';

// class CreateAccount extends Component {

//     constructor(props){
//         super(props);
//         this.handleSubmit = this.handleSubmit.bind(this);
//     }

//     handleSubmit(event){
//         alert(JSON.stringify(event));
//     }

//     render(){
//         return(
//             <Form onSubmit={this.handleSubmit}>
//                 <Row className="form-group">
//                 <Label htmlFor="accounttype">Account Type:</Label>
//                 <Col>
//                     <Input type="select" className="form-control" id="accounttype" innerRef={(input) => this.accounttype = input}>
//                         <option>Checking</option>
//                         <option>Savings</option>
//                         <option>Personal Checking</option>
//                         <option>Certificate Of Deposit</option>
//                         <option>DBA Checking</option>
//                     </Input>
//                 </Col>
//                 </Row>
//                 <Row className="form-group">
//                 <Label htmlFor="balance">Opening Balance</Label>
//                 <Col>
//                     <Input type="text" className="form-control" id="balance" placeholder="Opening Balance" innerRef={(input) => this.balance = input}/>
//                 </Col>
//                 </Row>
//                 <Row className="form-group">
//                     <Col>
//                         <Button type="submit" color="primary">
//                             Create Account
//                         </Button>
//                     </Col>
//                 </Row>
//             </Form>
//         );
//     }
// }

// export default CreateAccount