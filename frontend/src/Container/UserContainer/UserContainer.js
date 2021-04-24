import React, {Component} from "react";
import HigherOrderComponent from "../../HigherOrderComponent/HigherOrderComponent";
import Users from "../../Component/Users/Users";

class UserContainer extends Component {
    state = {
    };

    onChooseUserHandler = (userId) => {
        this.props.history.push(`/user/${userId}/photos`);
    }

    render() {
        return (
            <HigherOrderComponent>
                <Users choose={(userId) => this.onChooseUserHandler(userId)}/>
            </HigherOrderComponent>
        );
    }
};

export default UserContainer;