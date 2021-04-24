import React, {Component, useCallback} from 'react';
import Gallery from "react-photo-gallery";
import PhotoEditor from "../PhotoEditor/PhotoEditor";
import {Route, withRouter} from "react-router-dom";

import classes from './Photos.module.css';
import {clearUpCurrentUser, initUserImages, setUserImagesFromCache} from "../../Store/Action/image";
import {connect} from "react-redux";

class Photos extends Component {

    state = {
        edit: false,
        selectedImageSrc: null,
        selectedImageWidth: null,
        selectedImageId: null,
        photos: [
            {
                src: "https://source.unsplash.com/2ShvY8Lf6l0/800x599",
                width: 800,
                height: 599
            },
            {
                src: "https://source.unsplash.com/Dm-qxdynoEc/800x799",
                width: 800,
                height: 799
            },
            {
                src: "https://source.unsplash.com/qDkso9nvCg0/600x799",
                width: 600,
                height: 799
            },
            {
                src: "https://source.unsplash.com/iecJiKe_RNg/600x799",
                width: 600,
                height: 799
            },
            {
                src: "https://source.unsplash.com/epcsn8Ed8kY/600x799",
                width: 600,
                height: 799
            },
            {
                src: "https://source.unsplash.com/NQSWvyVRIJk/800x599",
                width: 800,
                height: 599
            },
            {
                src: "https://source.unsplash.com/zh7GEuORbUw/600x799",
                width: 600,
                height: 799
            },
            {
                src: "https://source.unsplash.com/PpOHJezOalU/800x599",
                width: 800,
                height: 599
            },
            {
                src: "https://source.unsplash.com/I1ASdgphUH4/800x599",
                width: 800,
                height: 599
            }
        ],
    }

    componentDidMount() {
        let userId = +this.props.match.params.id;
        console.log('userId' + userId);
        if (userId !== this.props.user.userId) {
            this.props.onClearUpCurrentUser();
            let isUserInTheCache = this.props.users.find(user => user.userId === userId && user.userImages.length > 0);
            console.log(isUserInTheCache);
            if (!isUserInTheCache) {
                this.props.onInitUserImages(userId);
            } else {
                this.props.onSetUserImagesFromCache(userId);
            }
        }
    }

    clickEventHandler = (event, {photo}) => {
        console.log(event);
        console.log(photo);
        let selectedImageSrc = null;
        let selectedImageWidth = null;
        let selectedImage = null;
        selectedImage = this.props.user.userImages.filter((userImage) => userImage.imageId === photo.imageId)[0];
        selectedImageSrc = selectedImage.src;
        selectedImageWidth = selectedImage.width;
        this.setState({edit: true, selectedImageId: photo.imageId, selectedImageSrc: selectedImageSrc, selectedImageWidth: selectedImageWidth*1.8});
    }

    clickEventHandlerCallback = this.clickEventHandler.bind(this);

    backButtonClickEvent = () => {
        this.setState({edit: false, selectedImageIndex: null, selectedImageSrc: null, selectedImageWidth: null});
    }

    render() {
        let image = null;
        let edit = null;
        let gallery = null;
        if (!this.state.edit) {
            if (this.props.user && this.props.user.userImages.length > 0) {
                image = (
                    <Gallery key={this.props.user.userId} photos={this.props.user.userImages} onClick={this.clickEventHandlerCallback} />
                );
            }
        } else {
            edit = (
                <PhotoEditor key={this.state.selectedImageId} userName={this.props.user.userName} imageSrc={this.state.selectedImageSrc} width={this.state.selectedImageWidth} back={this.backButtonClickEvent}/>
            );
        }
        return (
            <div className={classes.Photos}>
                {image}
                {edit}
            </div>
        );
    }
};

const mapStateToProps = state => {
    return {
        user: state.user,
        users: state.users
    }
};

const mapDispatchToProps = dispatch => {
    return {
        onInitUserImages: (userId) => dispatch(initUserImages(userId)),
        onSetUserImagesFromCache: (userId) => dispatch(setUserImagesFromCache(userId)),
        onClearUpCurrentUser: () => dispatch(clearUpCurrentUser())
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(withRouter(Photos));