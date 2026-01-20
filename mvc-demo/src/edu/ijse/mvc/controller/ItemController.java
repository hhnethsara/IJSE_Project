/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.dto.ItemDto;
import edu.ijse.mvc.model.ItemModel;

/**
 *
 * @author neths
 */
public class ItemController {
    private ItemModel itemModel;

    public ItemController() {
        itemModel = new ItemModel();
    }
    
    public ItemDto searchItem(String itemId) throws Exception {
        return itemModel.searchItem(itemId);
    }
}
