package com.inventorymnagement.main;

/**
 * Created by user on 22/04/2016.
 */
public class InventoryFactory {




    public Inventory getInventoryInstance(String type){

        if(type.toLowerCase().equals("argentina")){

            return new ArgentinaInventory(100,50);
        }
        else{

            if(type.toLowerCase().equals("brazil")){

                return new BrazilInventory(100,100,new ArgentinaInventory(100,50));
            }
        }
        return null;
    }
}
