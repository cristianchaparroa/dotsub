import React, { Component } from 'react';
import '../css/App.css';
import ProductForm from './components/product/ProductForm';

class Main extends Component {

  constructor(props) {
    super(props);
    this.state = {ponged: 'Not Ponged'}
  }

  render() {
    return (
      <ProductForm />
    );
  }
}

export default Main;
