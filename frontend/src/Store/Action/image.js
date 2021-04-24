import * as actionType from './actionType';
import axios from '../../axios-instance';

export const setUserImages = (data) => {
    return {
        type: actionType.SET_USER_IMAGES,
        user: data
    };
}

export const fetchUserImagesFailed = () => {
    return {
        type: actionType.FETCH_USER_IMAGES_FAILED
    }
}

export const initUserImages = (userId) => {
    return dispatch => {
        axios.get('/users/user/' + userId )
            .then(response => {
                dispatch(setUserImages(response.data));
            })
            .catch(error => {
                dispatch(fetchUserImagesFailed());
            })
    }
};

export const setUserImagesFromCache = (userId) => {
    return {
        type: actionType.SET_USER_IMAGES_FROM_CACHE,
        userId: userId
    };
};

export const clearUpCurrentUser = () => {
  return {
      type: actionType.CLEAR_UP_CURRENT_USER
  };
};