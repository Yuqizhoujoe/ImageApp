import React from "react";
import 'antd/dist/antd.css';

import classes from './User.module.css';
import { Card } from 'antd';

const { Meta } = Card;

const User = (props) => {
    return (
        <div className={classes.User}>
            <Card
                hoverable
                style={{ width: 350 }}
                cover={<img alt={props.imageName} src={props.imageSrc} height={400}/>}
                onClick={props.click}
            >
                <Meta title={props.userName} />
            </Card>
        </div>
    );
};

export default User;