import React, { Component } from 'react';
import { Card, CardTitle, CardBody, CardImg, CardSubtitle } from 'reactstrap';

class AboutUs extends Component {


    render(){
        return(
            <>
            <Card> 
                <CardTitle>Allana Gray</CardTitle>
                <CardSubtitle>Front-End Developer</CardSubtitle>
                <CardImg src="/allana.jpg" height="70" width="70" />
                <CardBody></CardBody>
            </Card>
            <Card> 
                <CardTitle>Wiliam Haywood</CardTitle>
                <CardSubtitle>Team Lead</CardSubtitle>
                <CardImg src="/will.jpg" height="70" width="70" />
                <CardBody></CardBody>
            </Card>
            <Card> 
                <CardTitle>Rod Wombles</CardTitle>
                <CardSubtitle>Back-End Developer</CardSubtitle>
                <CardImg src="/rod.jpg" height="70" width="70" />
                <CardBody></CardBody>
            </Card>
            </>
        );
    }
}

export default AboutUs