import React from 'react';
import'./Loginpage.css';


class Loginpage extends React.Component {


     constructor() {
         super();
         this.state = {
             err: ''


         };

     }
    login(e) {
        e.preventDefault();
        var username = e.target.elements.username.value;
        var password = e.target.elements.password.value;
        if (username == 'abc' && password == '123') {
            this.props.history.push('/Home/' + username);
        
        } else {
            this.setState({
                err: 'Invalid'

            });
        }

    }

    render() {

        let format = {
        color: "red"
        };
        return (
        
            <div>
                
                <h3> Login</h3>
                <span style={format}>{this.state.err != '' ? this.state.err : ''}</span>
                <form method="post">
                    Username <input type= "text" name="username"/>
                    <br/>
                    Password <input type= "password" name= "password"/>
                    <br/>
                    <input type ="submit" value= "Login"/>

                </form>
            </div>
        )
    }

}

export default Loginpage;

