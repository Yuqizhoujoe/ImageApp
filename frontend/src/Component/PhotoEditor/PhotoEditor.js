import React, {useState} from "react";
import {Button, Divider, Image} from "antd";
import { Typography } from 'antd';

import classes from './PhotoEditor.module.css';
import HigherOrderComponent from "../../HigherOrderComponent/HigherOrderComponent";

const { Paragraph } = Typography;

const style = {
    display: 'flex',
    width: '80%',
    flexDirection: 'row',
    alignItems: 'flex-start',
    justifyContent: 'space-around',
    marginBottom: '3.5rem',
}

const buttonStyle = {
    position: 'absolute',
    left: 0,
    display: 'inline-block',
    float: 'left',
    marginTop: '-3rem'
}

const PhotoEditor = (props) => {
    const [imageName, setImageName] = useState(props.userName);
    let br = [];
    for (let i = 0; i < 3; i++) {
        br.push(<br />);
    }
    return (
        <HigherOrderComponent>
            <Button
                type="danger"
                onClick={props.back}
                style={buttonStyle}
            >Back</Button>
            <div className={classes.PhotoEditor}>
                <Image
                    width={props.width}
                    src={props.imageSrc}
                />
                {br}
                <div style={style}>
                    <Paragraph className={classes.Paragraph} editable={{ onChange: setImageName }}> <span>Name: </span> {imageName}</Paragraph>
                </div>
            </div>
        </HigherOrderComponent>
    );
};

export default PhotoEditor;