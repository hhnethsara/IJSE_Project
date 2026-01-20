/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;
    
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;

/**
 *
 * @author neths
 */
public class ItemModel {

    public static ItemDto searchItem(String itemId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE ItemCode=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemId);
        ResultSet rst = statement.executeQuery();
        ItemDto dto = null;
        while(rst.next()){
            dto = new ItemDto();
            dto.setItemCode(rst.getString("ItemCode"));
            dto.setDescription(rst.getString("Description"));
            dto.setPacksize(rst.getString("Packsize"));
            dto.setUnitprice(rst.getDouble("UnitPrice"));
            dto.setQtyOnHand(rst.getInt("QtyOnHand"));
        }
                
        return dto;  
    }
    
}
