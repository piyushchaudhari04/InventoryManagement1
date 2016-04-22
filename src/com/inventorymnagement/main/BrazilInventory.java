package com.inventorymnagement.main;

/**
 * Created by user on 09/04/2016.
 */
public class BrazilInventory implements Inventory{

    private  int price;
    private int importQuanity;
    private int quantity;
    private int importPrice;
    private int quantityOrdered;
    ArgentinaInventory argentinaInventory;
    public BrazilInventory(int quantity,int price,Inventory argentinaInventory){


        this.quantity=quantity;
        this.price=price;
        importQuanity=0;
        importPrice=400;
        this.argentinaInventory=(ArgentinaInventory) argentinaInventory;
    }

    public void placeOrder(int quantity) throws InsufficientQuantityException {

        if(checkValidOrder(quantity)){

            quantityOrdered=quantity;
        }
        else{

            throw new InsufficientQuantityException("InsufficientQuantitExcpetion");
        }

    }



    public void importItem(int impoQuantity){

        importQuanity=impoQuantity;
        try {
            argentinaInventory.exportItem(impoQuantity);
        }
        catch(Exception e){}
    }

    public  int calculateMinimumPrice(){

        int quantity=quantityOrdered;
        int canItemImport=canImport(quantity);
        importItem(canItemImport);
        int priceOfImported=importItemPrice(quantity);
        int itemNotImported=quantityOrdered-canItemImport;
        if(priceInBazilAlone()>priceOfImported+itemNotImported*getPrice()){

            return priceOfImported+itemNotImported*getPrice();
        }
        else{

            return priceInBazilAlone();
        }

    }
    public void setQuantity(int quanity){

        this.quantity=quanity;
    }
    public int getQuantity(){

        return quantity;
    }
    public void setPrice(int price){

        this.price=price;
    }
    public  int getPrice(){

        return price;
    }
    public int priceInBazilAlone(){

        return price*quantityOrdered;
    }
    public int getImportQuanity(){

        return importQuanity;
    }
    public int canImport(int quantity){

        if(quantity>100){

            return 100;
        }

        else {
            return quantity - quantity % 10;
        }
    }
    public int importItemPrice(int quantity){

        return argentinaInventory.getPrice()*quantity+400*(quantity/10);
    }
    public boolean checkValidOrder(int quantity){

        if(quantity>200){

            return false;
        }
        else{

            return true;
        }
    }
    public void exportItem(int quantity){}
    public int stock(){

        return quantity-(quantityOrdered-importQuanity);
    }

}
