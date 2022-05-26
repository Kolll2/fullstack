import React from "react";
import {Link} from "react-router-dom";

function Navbar() {
    let userId = 5;
    return (
        <div>
            <h3>Menu</h3>
            <ul>
                <li key="home-link"><Link to="/">Home</Link></li>
                <li key="user-link"><Link to={{pathname: '/users/' + userId}}>User</Link></li>
            </ul>
        </div>
    )
}

export default Navbar
