import * as actionType from './actionType';
import axios from '../../axios-instance';

export const setUsers = (users) => {
    return {
        type: actionType.SET_USERS,
        users: users
    };
};

export const fetchUsersFailed = () => {
    return {
        type: actionType.FETCH_USERS_FAILED
    };
};

export const initUsers = () => {
    return dispatch => {
        axios.get('/users')
            .then(response => {
                dispatch(setUsers(response.data));
            })
            .catch(error => {
                dispatch(fetchUsersFailed());
            });
    }
};