import React, { Component } from 'react';
import Navbar from './NavbarComponent';
import Footer from './FooterComponent';
import LoginPage from './LoginPageComponent';
import CreateAccount from './CreateAccountComponent';
import AboutUs from './AboutComponent';
import CreateUser from './CreateUserComponent';
import { Route, Redirect, Switch, withRouter } from 'react-router-dom';
import Home from './HomeComponent';
import { fetchSavingsAccount, fetchCheckingAccounts, fetchCdAccounts, fetchPersonalCheckingAccount, fetchDbaCheckingAccounts, fetchUser, postUser } from '../redux/ActionCreators';
import { actions, Form } from 'react-redux-form'
import { connect } from 'react-redux';


const mapStateToProps = state => {
    return {
        user: state.user,
        savingsAccount: state.savingsAccount,
        checkingAccounts: state.checkingAccounts,
        cdAccounts: state.cdAccounts,
        personalCheckingAccount: state.personalCheckingAccount,
        dbaCheckingAccount: state.dbaCheckingAccount
    }
}

const mapDispatchToProps = (dispatch) => ({
    postUser: () => dispatch(postUser()),
    fetchUser: () => dispatch(fetchUser()),
    fetchSavingsAccount: () =>  dispatch(fetchSavingsAccount()) ,
    fetchCheckingAccounts: () =>  dispatch(fetchCheckingAccounts()) ,
    fetchCdAccounts: () =>  dispatch(fetchCdAccounts()) ,
    fetchPersonalCheckingAccount: () =>  dispatch(fetchPersonalCheckingAccount()) ,
    fetchDbaCheckingAccounts: () =>  dispatch(fetchDbaCheckingAccounts()) 
});


class Main extends Component {
    
    constructor(props) {
        super(props);

    }

    componentDidMount() {
        this.props.fetchUser();
        this.props.fetchSavingsAccount();
        this.props.fetchCheckingAccounts();
        this.props.fetchCdAccounts();
        this.props.fetchPersonalCheckingAccount();
        this.props.fetchDbaCheckingAccounts();
    }

    render() {

        const HomePage = () => {
            return(
                <Home user={this.props.user}
                savingsAccount={this.props.savingsAccount.account}
                checkingAccounts={this.props.checkingAccounts.accounts}
                cdAccounts={this.props.cdAccounts.accounts}
                personalCheckingAccount={this.props.personalCheckingAccount.account}
                dbaCheckingAccount={this.props.dbaCheckingAccount.accounts}/>
            );
        }

        return(
            <div>
                <Navbar/>
                <Switch>
                    <Route path='/home' component={HomePage} />
                    <Route path='/aboutus' component={() => <AboutUs />} />
                    <Route path='/signin' component={() => <LoginPage />} />
                    <Route path='/createaccount' component={() => <CreateAccount />} />
                    <Route path='/register' component={() => <CreateUser postUser={this.props.postUser}/>} />
                </Switch>
                <Footer/>
            </div>
        );
    }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));