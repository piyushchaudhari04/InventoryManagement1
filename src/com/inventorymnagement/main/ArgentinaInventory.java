package com.inventorymnagement.main;

/**
 * Created by user on 09/04/2016.
 */
public class ArgentinaInventory implements Inventory {

    private int price;
    private int quantity;
    private int quantityOrdered;
    public ArgentinaInventory(int quantity,int price){

       this.quantity=quantity;
        this.price=price;
        quantityOrdered=0;
    }

    public void placeOrder(int quantity) throws InsufficientQuantityException {

        if(checkValidOrder(quantity)){

            quantityOrdered=quantity;
        }
        else{

            throw new InsufficientQuantityException("InsufficientQuantitExcpetion");
        }
    }
    public void exportItem(int expoQuantity) throws InsufficientQuantityException {

            if(quantity-expoQuantity>=0){

                quantity-=expoQuantity;
            }
            else{

                throw new InsufficientQuantityException("InsufficientQuantitExcpetion");
            }
    }
    public int calculateMinimumPrice(){

            return price*quantityOrdered;
    }
    public int getPrice(){

        return price;
    }
    public void setPrice(int price){

        this.price=price;
    }
    public void setQuantity(int quantity){

        this.quantity=quantity;
    }
    public int getQuantity(){

        return quantity;
    }
    public boolean checkValidOrder(int quantity){

        if(quantity>100){

            return false;
        }
        else{

            return true;
        }
    }
    public int stock(){

        return quantity-quantityOrdered;
    }
    public void importItem(int quantity){}
}
