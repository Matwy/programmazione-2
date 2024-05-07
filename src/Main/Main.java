package Main;
import Data.UI.*;
import Data.Point;
import Exceptions.BlockErrorException;
import Exceptions.OutOfMapException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
        Main.test_picking();
    }

    public static void test(){
        Map map = new Map(8, 8);

        try {
            map.insertBlockAtPoint(new Point(), 'S');
            map.insertBlockAtPoint(new Point(), 'S');
            map.insertBlockAtPoint(new Point(), 'S');
        } catch (OutOfMapException e) {
            throw new RuntimeException(e);
        }
        map.DisplayOnOut();
    }
    public static void test_picking(){
        int INTERACTIONS = 99;
        MainView m = new MainView();
        m.DisplayInOut();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '9' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9){
                try {
                    m.fromInventoryIntoFurnace(col);
                } catch (BlockErrorException e) {
                    throw new RuntimeException(e);
                }
            }else if( row == 99 ){
                if (col == 9) {
                    m.smelt();
                }else if (col == 0){
                    m.toggleInventoryComparator();
                }else {
                    m.fromFurnaceIntoInventory();
                }
            } else{
                Point c = new Point(row,col);
                try {
                    m.pickUpBlock(c);
                } catch (OutOfMapException | BlockErrorException e) {
                    throw new RuntimeException(e);
                }
            }
            m.DisplayInOut();
        }
    }
}
