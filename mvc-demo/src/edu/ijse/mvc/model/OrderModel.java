/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;
import edu.ijse.mvc.dto.OrderDetailDto;
import edu.ijse.mvc.dto.OrderDto;
import java.util.ArrayList;

/**
 *
 * @author neths
 */
public class OrderModel {

    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            String ordersql = "INSERT INTO Orders VALUES(?,?,?)";
            PreparedStatement orderstatement = connection.prepareStatement(ordersql);
            orderstatement.setString(1, orderDto.getOrderId());
            orderstatement.setString(2, orderDto.getOrderDate());
            orderstatement.setInt(3, orderDto.getCustID());

            boolean isOrderSave = orderstatement.executeUpdate() > 0;
            if (isOrderSave) {
                boolean isOrderDetailsave = true;
                String orderDetailsql = "INSERT INTO orderdetail VALUES(?,?,?,?)";
                for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    PreparedStatement orderdetailstatement = connection.prepareStatement(orderDetailsql);
                    orderdetailstatement.setString(1, orderDto.getOrderId());
                    orderdetailstatement.setString(2, orderDetailDto.getItemCode());
                    orderdetailstatement.setInt(3, orderDetailDto.getOrderQty());
                    orderdetailstatement.setDouble(4, orderDetailDto.getDiscount());

                    if (!(orderdetailstatement.executeUpdate() > 0)) {
                        isOrderDetailsave = false;
                    }
                }
                if (isOrderDetailsave) {
                    boolean isItemUpdate = true;
                    String itemUpdate = "UPDATE item SET QtyOnHand=QtyOnHand-? WHERE ItemCode=?";
                    for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                        PreparedStatement itemstatement = connection.prepareStatement(itemUpdate);
                        itemstatement.setInt(1, orderDetailDto.getOrderQty());
                        itemstatement.setString(2, orderDetailDto.getItemCode());
                        if (!(itemstatement.executeUpdate() > 0)) {
                        isOrderDetailsave = false;
                    }
                    }
                    if(isOrderDetailsave){
                        connection.commit();
                        return "SUCCSESS";
                    }else{
                        connection.rollback();
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Details Save Error";
                }

            } else {
                connection.rollback();
                return "Order Sava Error";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }
        
    }
}
