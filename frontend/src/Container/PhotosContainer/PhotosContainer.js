import React, {Component} from "react";
import HigherOrderComponent from "../../HigherOrderComponent/HigherOrderComponent";
import Photos from "../../Component/Photos/Photos";

class PhotosContainer extends Component {
    render() {
        return (
            <HigherOrderComponent>
                <Photos />
            </HigherOrderComponent>
        );
    }
};

export default PhotosContainer;