package com.inventorymnagement.main;

/**
 * Created by user on 19/04/2016.
 */
public class InsufficientQuantityException extends Exception{

    public InsufficientQuantityException(String s){

        super(s);
    }
}
