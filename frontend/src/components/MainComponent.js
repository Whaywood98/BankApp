import React, { Component } from 'react';
import Header from './HeaderComponent';
import { Route, Redirect, Switch, withRouter } from 'react-router-dom';
import Home from './HomeComponent';
import { fetchSavingsAccount, fetchCheckingAccounts, fetchCdAccounts, fetchPersonalCheckingAccount, fetchDbaCheckingAccounts, fetchUser } from '../redux/ActionCreators';
import { actions, Form } from 'react-redux-form'
import { connect } from 'react-redux';
import AboutUs from './AboutComponent';
import CreateUser from './CreateUserComponent';


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
                <Header/>
                <Switch>
                    <Route path='/home' component={HomePage} />
                    <Route path='/aboutus' component={() => <AboutUs />} />
                    <Route path='/createaccount' component={() => <CreateUser />} />
                </Switch>
            </div>
        );
    }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));