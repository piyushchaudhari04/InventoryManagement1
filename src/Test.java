import com.inventorymnagement.main.*;

import java.util.Scanner;

/**
 * Created by user on 10/04/2016.
 */
public class Test {

    public static void main(String[] args){

       System.out.println("Welcome to inventory management");
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the name of the city and quanity");
        String countryName=sc.next();
        String temp=sc.next();
        int quantityOrdered=sc.nextInt();
        InventoryFactory inventoryFactory=new InventoryFactory();
        Inventory inventory=inventoryFactory.getInventoryInstance(countryName);

             if(inventory==null){

                 System.out.println("invalid country name");
                 return;
             }

            try {
                inventory.placeOrder(quantityOrdered);
                System.out.print(inventory.calculateMinimumPrice()+" "+inventory.stock()+" "+inventory.stock());

            }
            catch (InsufficientQuantityException e){}
    }
}
