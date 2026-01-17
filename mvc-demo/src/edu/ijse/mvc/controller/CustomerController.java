/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.dto.CustomerDto;
import edu.ijse.mvc.model.CustomerModel;

/**
 *
 * @author neths
 */
public class CustomerController {
    private CustomerModel customerModel;

    public CustomerController() {
        customerModel = new CustomerModel();
    }
    
    public String saveCustomer(CustomerDto customerDto)throws Exception{
        return customerModel.saveCustomer(customerDto);
    }
}
