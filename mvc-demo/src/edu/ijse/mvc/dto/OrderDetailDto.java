/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author neths
 */
public class OrderDetailDto {
    private String OrderId;
    private String ItemCode;
    private int OrderQty;
    private Double Discount;

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
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    /**
     * @return the OrderQty
     */
    public int getOrderQty() {
        return OrderQty;
    }

    /**
     * @param OrderQty the OrderQty to set
     */
    public void setOrderQty(int OrderQty) {
        this.OrderQty = OrderQty;
    }

    /**
     * @return the Discount
     */
    public Double getDiscount() {
        return Discount;
    }

    /**
     * @param Discount the Discount to set
     */
    public void setDiscount(Double Discount) {
        this.Discount = Discount;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" + "OrderId=" + OrderId + ", ItemCode=" + ItemCode + ", OrderQty=" + OrderQty + ", Discount=" + Discount + '}';
    }
    
    
}
