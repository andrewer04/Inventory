import java.io.Console;
import java.util.Scanner;

public class Bag {
    private int width=0;
    private int height=0;
    private int itemNumber=0;
    private Item[] items;
    private int[][] bag;

    public void setDimensions() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] parts = input.split(" ");

        height = Integer.parseInt(parts[0]);
        width = Integer.parseInt(parts[1]);
    }

    public void setItemNumber(){
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();

        itemNumber = input;
    }

    public void setItems(){
        Scanner s = new Scanner(System.in);
        items = new Item[itemNumber];
        for (int i = 0; i<itemNumber; i++){
            String input = s.nextLine();
            String[] parts = input.split(" ");

            items[i] = new Item();
            items[i].setHeight(Integer.parseInt(parts[0]));
            items[i].setWidth(Integer.parseInt(parts[1]));
        }
    }

    public void initializeBag(){
        int i,j;
        bag = new int[height][width];
        for (i = 0; i<height; i++){
            for (j = 0; j<width; j++){
                bag[i][j] = 0;
            }
        }
    }

    public void printBag(){
        int i,j;
        for (i = 0; i<height; i++) {
            for (j = 0; j < width; j++) {
                System.out.print(bag[i][j]);
            }
            System.out.print("\n");
        }
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getItemNumber(){
        return itemNumber;
    }
    public Item[] getItems(){
       return items;
    }

}
