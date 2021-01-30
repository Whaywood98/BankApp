import { BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import './App.css';
import Login from './Components/pages/Login/Loginpage';
import Navbar from './Components/Navbar';
import Footer from './Components/pages/Footer/Footer';
import Home from './Components/pages/Homepage/Home';



function App() {
  return (
    <Router>
      <Navbar />
      <Switch>
      <Route path= '/' exact component = {Home}/>
      <Route path= '/' eact component ={Login}/>
      
    </Switch>
    <Footer/>
    </Router>
  );
}
export default App;
