import React, { Component } from 'react';
import axios from 'axios';
import {Button, ControlLabel, FormControl, FormGroup} from 'react-bootstrap';

class ProductForm extends Component {
  constructor(props) {
    super(props);
    this.state = {title:'', description:'',file: '',imagePreviewUrl: ''};
  }

  create() {

    let url = 'http://localhost:8080/api/product';
    const data = new FormData();
    data.append('image', this.state.file);
    data.append('title', this.state.title);
    data.append('description', this.state.description);

    axios.post(url, data)
      .then(function(res) {
          alert("The product "+res.data.title+" was saved sucessfully");
      })
      .catch(function(err) {
        console.error(err);
    });

  }

  handleTitle(e) {
    this.state.title = e.target.value;
  }

  handleDescription(e) {
    this.state.description = e.target.value;
  }

  _handleSubmit(e) {
    e.preventDefault();
    if (this.state.file !== '') {
        this.create();
    }
  }

  _handleImageChange(e) {
    e.preventDefault();

    let reader = new FileReader();
    let file = e.target.files[0];

    reader.onloadend = () => {
      this.setState({
        file: file,
        imagePreviewUrl: reader.result
      });
    }

    reader.readAsDataURL(file);
  }

  render() {
    let {imagePreviewUrl} = this.state;
    let $imagePreview = null;
    if (imagePreviewUrl) {
      $imagePreview = (<img src={imagePreviewUrl} style={{maxWidth:'400px', maxHeight: '400px'}}/>);
    } else {
      $imagePreview = (<div className="previewText">Please select an image for preview</div>);
    }


    return (
      <div style={{margin:'40px'}}>
        <form>
          <ControlLabel>Create a new Prodcut</ControlLabel>

          <FormGroup>
            <FormControl type="text" placeholder="Title product"  onChange={(e)=>this.handleTitle(e)} />
          </FormGroup>

          <FormGroup>
            <FormControl type="text" placeholder="Description" onChange={(e)=>this.handleDescription(e) }/>
          </FormGroup>

          <FormGroup>
            <input className="fileInput" type="file" onChange={(e)=>this._handleImageChange(e)} />
          </FormGroup>

          <Button onClick={(e)=>this._handleSubmit(e)} bsStyle="primary" block>Submit</Button>
        </form>
        <div>
          {$imagePreview}
        </div>
      </div>
    )
  }
}

export default ProductForm;
