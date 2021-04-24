import React, { Component } from "react";
import User from "./User/User";
import {Col, Image, Row} from "antd";
import 'antd/dist/antd.css';
import red from '../../asset/image/Yumi Kuang/Yumi Kuang6.jpg';
import green from '../../asset/image/Yumi Green.jpg';
import black from '../../asset/image/Yumi Black.jpg';
import classes from './Users.module.css';
import {initUsers} from "../../Store/Action/user";
import {connect} from "react-redux";

const userStyle = {
    marginTop: '4rem',
}

class Users extends Component {

    componentDidMount() {
        if (this.props.users.length === 0 || this.props.users === null) {
            this.props.onInitUsers();
        }
    }

    render() {
        let users = null;
        console.log(this.props.users);
        if (this.props.users && this.props.users.length > 0) {
            users = this.props.users.map(user => {
                return (
                    <Col className="gutter-row" span={5} key={user.userId}>
                        <User key={user.userId}
                              imageSrc={user.userProfilePicByte}
                              userName={user.userName}
                              imageName={user.userName}
                              click={() => this.props.choose(user.userId)}
                        />
                    </Col>
                );
            });
        }
        return (
            <div style={userStyle}>
                <Row gutter={16} className={classes.Row}>
                    {users}
                </Row>
            </div>
        );
    }
};

const mapStateToProps = state => {
    return {
        users: state.users
    }
};

const mapDispatchToProps = dispatch => {
    return {
        onInitUsers: () => dispatch(initUsers())
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(Users);