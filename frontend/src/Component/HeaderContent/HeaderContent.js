import React from "react";
import {Button} from "antd";
import {NavLink} from "react-router-dom";

const style = {
    width: 'inherit',
    height: 'inherit'
}

const button = {
    position: 'absolute',
    left: 0,
    display: 'inline-block',
    float: 'left'
}

const icon = {
    color: '#fff'
}

const paragraph = {
    color: '#fff',
    height: 'inherit',
    textAlign: 'center',
    fontSize: '2rem'
}

const HeaderContent = (props) => {
    return (
        <div style={style}>
            <Button type="primary" style={button}>
                <NavLink to="/" exact>
                    Home
                </NavLink>
            </Button>
            <p style={paragraph}>Image Album</p>
        </div>
    );
};

export default HeaderContent;