/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author neths
 */
public class OrderDto {
    private String OrderId;
    private String OrderDate;
    private int CustID;

    /**
     * @return the OrderId
     */
    public String getOrderId() {
        return OrderId;
    }

    /**
     * @param OrderId the OrderId to set
     */
    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    /**
     * @return the OrderDate
     */
    public String getOrderDate() {
        return OrderDate;
    }

    /**
     * @param OrderDate the OrderDate to set
     */
    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    /**
     * @return the CustID
     */
    public int getCustID() {
        return CustID;
    }

    /**
     * @param CustID the CustID to set
     */
    public void setCustID(int CustID) {
        this.CustID = CustID;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "OrderId=" + OrderId + ", OrderDate=" + OrderDate + ", CustID=" + CustID + '}';
    }
    
}
