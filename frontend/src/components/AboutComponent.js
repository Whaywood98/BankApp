import { relativeTimeRounding } from 'moment';
import React, { Component } from 'react';
import { Card, CardTitle, CardBody, CardImg, CardSubtitle } from 'reactstrap';
import'../css/Aboutus.css';

class AboutUs extends Component {


    render(){
        return(
            <>
             <div class = "Aboutus-Wrapper">
            <Card  style={{width:"250px", height:"250px", padding: '40px', left: "10px", position:"relative",top: "-170px"  }}> 
                <CardTitle tag="h5" className="mb-1">Allana Gray</CardTitle>
                <CardSubtitle tag="h6" className="mb-3" >Front-End Developer</CardSubtitle>
                <CardImg src="/allana.jpg" height="180" width="200" />
                <CardBody></CardBody>
            </Card>
            <Card style={{width:"250px", height:"250px", padding: '40px',  position:"relative", left: "-220px" ,top: "-170px"  }}> 
                <CardTitle tag="h5" className="mb-1"> William Haywood</CardTitle>
                <CardSubtitle tag="h6" className="mb-2">Team Lead</CardSubtitle>
                <CardImg src="/will.jpg" height="180" width="200"/>
                <CardBody></CardBody>
            </Card >
            <Card style={{width:"250px", height:"250px", padding: '40px',  position:"relative", left: "-450px" ,top: "-170px"  }}> 
                <CardTitle tag="h5" className="mb-1"> Rod Wombles</CardTitle>
                <CardSubtitle tag="h6" className="mb-3">Back-End Developer</CardSubtitle>
                <CardImg src="/rod.jpg" height="180" width="200"/>
                <CardBody></CardBody>
            </Card>
            </div>
            </>
        );
    }
}

export default AboutUs