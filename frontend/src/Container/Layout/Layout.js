import React, {Component} from 'react';
import HigherOrderComponent from "../../HigherOrderComponent/HigherOrderComponent";
import {Button, Layout} from 'antd';
import classes from './Layout.module.css';
import 'antd/dist/antd.css';
import HeaderContent from "../../Component/HeaderContent/HeaderContent";

const { Header, Footer } = Layout;

class LayoutContainer extends Component {
    render() {
        return (
          <div className={classes.LayoutContainer}>
              <Header className={classes.Header}>
                  <HeaderContent />
              </Header>
              <main>
                  {this.props.children}
              </main>
              <Footer className={classes.Footer}>Thank You</Footer>
          </div>
        );
    }
};

export default LayoutContainer;