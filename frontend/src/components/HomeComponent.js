import React from 'react';
import { Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';

// function RenderUserAccounts({ account }){
//   if(account != null){
//     return(
//           <Card>
//             <Link to={`/${account.accountType}`}>
//               <CardTitle>{account.accountType}</CardTitle>
//               <CardBody>{account.amount}</CardBody>
//             </Link>
//           </Card>
//     )
//   } else{
//     return(
//       <Card>
//         <CardTitle>Create Account?</CardTitle>
//       </Card>
//     )
//   }
// }

function Home(props) {
    
//   const userAccounts = props.accounts.map((account) => {
//     return(
//       <div key={account.accountType} className="col-12">
//         <RenderUserAccounts account={account} />
//       </div>
//     )
//   });

  return(
      <div className="container">
        <h4>Home</h4>
     {/* {userAccounts} */}
      </div>
    );
}

export default Home;   