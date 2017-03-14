public class Main {

    public static void main(String[] args) {

        Bag bag = new Bag();
        //bag.setDimensions();
        //bag.setItemNumber();
        //bag.setItems();

        //bag.setDim();
        //bag.setItemNumber();
        //bag.setIt();

        bag.ultimateScan();

        /*
        try{
            bag.setDimBuff();
            bag.setItemNumberBuff();
            bag.setItemsBuff();
        }catch (Exception e){
        }
        */

        bag.initializeBag();
        bag.sort2();

        /*
        bag.printBag();
        System.out.println(bag.getHeight() + " " + bag.getWidth());
        System.out.println(bag.getItemNumber());
        for (int i = 0; i<bag.getItemNumber(); i++){
            System.out.println(bag.getItems()[i].getHeight() + " " + bag.getItems()[i].getWidth());
        }
        */

        bag.insertItems();
        bag.printBag();



    }
}
