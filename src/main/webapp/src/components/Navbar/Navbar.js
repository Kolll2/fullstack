import React from "react";
import {Link} from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import {MenuItem} from "@mui/material";
import {makeStyles} from 'tss-react/mui';

const useStyles = makeStyles()((theme) => {
    return {
        root: {
            flexGrow: 1,
        },
        menuButton: {
            marginRight: theme.spacing(2),
        },
        title: {
            flexGrow: 1,
            textAlign: "left"
        },
        link: {
            textDecoration: "none",
            boxShadow: "none",
            color: "white"
        }
    };
});

function Navbar() {
    let userId = 5;
    const {classes} = useStyles();
    return (
        <div>
            <AppBar position="static">
                <Toolbar>
                    <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
                        <MenuIcon/>
                    </IconButton>
                    <MenuItem>
                        <Typography>
                            <Link className={classes.link} to="/">Home</Link>
                        </Typography>
                    </MenuItem>
                    <MenuItem>
                        <Link className={classes.link} to={{pathname: '/users/' + userId}}>User</Link>
                    </MenuItem>
                </Toolbar>
            </AppBar>
        </div>
    )
}

export default Navbar
