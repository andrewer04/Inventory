import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bag bag = new Bag();
        bag.setDimensions();
        bag.setItemNumber();
        bag.setItems();

        bag.initializeBag();
        bag.printBag();

        //System.out.println(bag.getHeight() + " " + bag.getWidth());
        System.out.println(bag.getItemNumber());
        for (int i = 0; i<bag.getItemNumber(); i++){
            System.out.println(bag.getItems()[i].getHeight() + " " + bag.getItems()[i].getWidth());
        }

    }
}