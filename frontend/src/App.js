import React, {Component} from "react";
import UserContainer from "./Container/UserContainer/UserContainer";
import {Route, Switch} from 'react-router-dom';
import PhotosContainer from "./Container/PhotosContainer/PhotosContainer";
import LayoutContainer from "./Container/Layout/Layout";

import classes from './App.module.css';

class App extends Component {
  render() {
    return (
        <div className={classes.App}>
          <LayoutContainer>
            <Switch>
                <Route path="/user/:id/photos/" exact component={PhotosContainer} />
                <Route path="/" component={UserContainer} exact />
            </Switch>
          </LayoutContainer>
        </div>
    );
  }
};

export default App;