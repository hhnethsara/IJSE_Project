/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.CustomerDto;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author neths
 */
public class CustomerModel {

    public String saveCustomer(CustomerDto customerDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, customerDto.getCustId());
        statement.setString(2, customerDto.getTitle());
        statement.setString(3, customerDto.getName());
        statement.setString(4, customerDto.getDob());
        statement.setDouble(5, customerDto.getSalary());
        statement.setString(6, customerDto.getAddress());
        statement.setString(7, customerDto.getCity());
        statement.setString(8, customerDto.getProvince());
        statement.setString(9, customerDto.getZip());

        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "fail";
        }

    }

    public ArrayList<CustomerDto> getAllCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();

        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        while (rst.next()) {
            CustomerDto dto = new CustomerDto();
            dto.setCustId(rst.getInt("CustID"));
            dto.setTitle(rst.getString("CustTitle"));
            dto.setName(rst.getString("CustName"));
            dto.setAddress(rst.getString("Address"));
            dto.setDob(rst.getString("DOB"));
            dto.setSalary(rst.getDouble("Salary"));
            dto.setCity(rst.getString("City"));
            dto.setProvince(rst.getString("Province"));
            dto.setZip(rst.getString("Zip"));

            customerDtos.add(dto);
        }
        return customerDtos;
    }

    public CustomerDto searchCustomerDto(int id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE CustID =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rst = statement.executeQuery();

        CustomerDto dto = null;
        while (rst.next()) {
            dto = new CustomerDto();
            dto.setCustId(rst.getInt("CustID"));
            dto.setTitle(rst.getString("CustTitle"));
            dto.setName(rst.getString("CustName"));
            dto.setAddress(rst.getString("Address"));
            dto.setDob(rst.getString("DOB"));
            dto.setSalary(rst.getDouble("Salary"));
            dto.setCity(rst.getString("City"));
            dto.setProvince(rst.getString("Province"));
            dto.setZip(rst.getString("Zip"));

        }
        return dto;
    }

    public String updateCustomer(CustomerDto customerDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE customer SET CustTitle=?,CustName=?,DOB=?,Salary=?,Address=?,City=?,Province=?,Zip=? WHERE CustID=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customerDto.getTitle());
        statement.setString(2, customerDto.getName());
        statement.setString(3, customerDto.getDob());
        statement.setDouble(4, customerDto.getSalary());
        statement.setString(5, customerDto.getAddress());
        statement.setString(6, customerDto.getCity());
        statement.setString(7, customerDto.getProvince());
        statement.setString(8, customerDto.getZip());
        statement.setInt(9, customerDto.getCustId());

        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "fail";
        }
    }

    public String deleteCustomer(int custId) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE CustID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, custId);
        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "fail";
        }
    }
}
