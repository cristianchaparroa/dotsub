import React from 'react';
import { shallow } from 'enzyme';
import renderer from 'react-test-renderer';


import ProductForm from  './ProductForm';


it('renders "Our Product Form component contains title description"', () => {
  const wrapper = shallow(<ProductForm/>);
  const textHeader = 'Create a new Prodcut';
  expect(wrapper.contains(textHeader)).toEqual(true);
});

it('renders "Our Product Form component contains a submint button "', () => {
  const wrapper = shallow(<ProductForm/>);
  const textSubmitButton = 'Submit';
  expect(wrapper.contains(textSubmitButton)).toEqual(true);
});
