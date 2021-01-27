import React, { Component } from 'react';
import Header from './HeaderComponent';
import { Route, Redirect, Switch, withRouter } from 'react-router-dom';
import Home from './HomeComponent';
import { fetchSavingsAccount, fetchCheckingAccounts, fetchCdAccounts, fetchPersonalCheckingAccount, fetchDbaCheckingAccounts } from '../redux/ActionCreators';
import { actions } from 'react-redux-form'
import { connect } from 'react-redux';


const mapStateToProps = state => {
    return {
        savingsAccount: state.savingsAccount,
        checkingAccounts: state.checkingAccounts,
        cdAccounts: state.cdAccounts,
        personalCheckingAccount: state.personalCheckingAccount,
        dbaCheckingAccount: state.dbaCheckingAccount
    }
}

const mapDispatchToProps = (dispatch) => ({
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
        this.props.fetchSavingsAccount();
        this.props.fetchCheckingAccounts();
        this.props.fetchCdAccounts();
        this.props.fetchPersonalCheckingAccount();
        this.props.fetchDbaCheckingAccounts();
    }

    render() {

        const HomePage = () => {
            return(
                <Home savingsAccount={this.props.savingsAccount.account}
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
                </Switch>
            </div>
        );
    }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));