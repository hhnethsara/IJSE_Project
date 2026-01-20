/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author neths
 */
public class ItemDto {
    private String ItemCode;
    private String Description;
    private String Packsize;
    private double Unitprice;
    private int QtyOnHand;

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
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the Packsize
     */
    public String getPacksize() {
        return Packsize;
    }

    /**
     * @param Packsize the Packsize to set
     */
    public void setPacksize(String Packsize) {
        this.Packsize = Packsize;
    }

    /**
     * @return the Unitprice
     */
    public double getUnitprice() {
        return Unitprice;
    }

    /**
     * @param Unitprice the Unitprice to set
     */
    public void setUnitprice(double Unitprice) {
        this.Unitprice = Unitprice;
    }

    /**
     * @return the QtyOnHand
     */
    public int getQtyOnHand() {
        return QtyOnHand;
    }

    /**
     * @param QtyOnHand the QtyOnHand to set
     */
    public void setQtyOnHand(int QtyOnHand) {
        this.QtyOnHand = QtyOnHand;
    }

    @Override
    public String toString() {
        return "ItemDto{" + "ItemCode=" + ItemCode + ", Description=" + Description + ", Packsize=" + Packsize + ", Unitprice=" + Unitprice + ", QtyOnHand=" + QtyOnHand + '}';
    }
    
    
}
