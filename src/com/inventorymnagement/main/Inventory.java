package com.inventorymnagement.main;

/**
 * Created by user on 19/04/2016.
 */
public interface Inventory {
    public void placeOrder(int quantity) throws InsufficientQuantityException;
    public int calculateMinimumPrice();
    public void exportItem(int quantity) throws InsufficientQuantityException;
    public void importItem(int quantity);
    public int stock();
}
