import * as actionType from '../Action/actionType';

const initialState = {
    users: [],
    user: {
        userId: null,
        userName: null,
        userProfilePicByte: null,
        userProfilePicWidth: null,
        userProfilePicHeight: null,
        userImages: []
    },
    fetchUsersError: false,
    fetchUserError: false
}

const user = (state = initialState, action) => {
    switch (action.type) {
        case actionType.SET_USERS:
            return {
                ...state,
                users: action.users
            };
        case actionType.FETCH_USERS_FAILED:
            return {
                ...state,
                fetchUsersError: true
            };
        case actionType.SET_USER_IMAGES:
            let user = action.user;
            let userImages = [...action.user.userImages];
            let transformUserImages = userImages.map(userImage => {
                return {
                    imageId: userImage.imageId,
                    src: userImage.userPicByte,
                    width: userImage.userPicWidth,
                    height: userImage.userPicHeight
                };
            });
            let updatedUsers = [...state.users.map(user => {
                let updateUser = {...user};
                if (user.userId === action.user.userId) {
                    updateUser.userImages = transformUserImages;
                }
                return updateUser;
            })];
            user.userImages = transformUserImages;
            return {
                ...state,
                user: user,
                users: updatedUsers
            };
        case actionType.FETCH_USER_IMAGES_FAILED:
            return {
                ...state,
                fetchUserError: true
            };
        case actionType.SET_USER_IMAGES_FROM_CACHE:
            let selectedUser = state.users.find(user => {
                return user.userId === action.userId && user.userImages && user.userImages.length > 0;
            });
            return {
                ...state,
                user: selectedUser
            };
        case actionType.CLEAR_UP_CURRENT_USER:
            return {
                ...state,
                user: null
            }
        default:
            return state;
    }
};

export default user;