import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        String[] parts = input.split("\t");

        height = Integer.parseInt(parts[0]);
        width = Integer.parseInt(parts[1]);
    }
    public void setDim(){
        Scanner s = new Scanner(System.in);
        height = s.nextInt();
        width = s.nextInt();
    }
    public void setDimBuff() throws Exception {
        BufferedReader b = new BufferedReader( new InputStreamReader(System.in));
        String input = b.readLine();

        String[] parts = input.split("\t");

        height = Integer.parseInt(parts[0]);
        width = Integer.parseInt(parts[1]);
    }

    public void setItemNumber(){
        Scanner s = new Scanner(System.in);
        itemNumber = s.nextInt();
    }
    public void setItemNumberBuff() throws Exception{
        BufferedReader bu = new BufferedReader( new InputStreamReader(System.in));
        String input = bu.readLine();
        itemNumber = Integer.parseInt(input);
    }

    public void setItems(){
        Scanner s = new Scanner(System.in);
        items = new Item[itemNumber];
        for (int i = 0; i<itemNumber; i++){
            String input = s.nextLine();
            String[] parts = input.split("\t");

            items[i] = new Item();
            items[i].setHeight(Integer.parseInt(parts[0]));
            items[i].setWidth(Integer.parseInt(parts[1]));
            items[i].setName(i+1);
        }
    }
    public void setIt(){
        Scanner s = new Scanner(System.in);
        items = new Item[itemNumber];
        for (int i = 0; i < itemNumber; i++) {
            int h = s.nextInt();
            int w = s.nextInt();

            items[i] = new Item();
            items[i].setHeight(h);
            items[i].setWidth(w);
            items[i].setName(i + 1);
        }
    }
    public void setItemsBuff() throws Exception{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        items = new Item[itemNumber];
        for (int i = 0; i <itemNumber; i++){
            String input = b.readLine();
            String[] parts = input.split("\t");

            items[i] = new Item();
            items[i].setHeight(Integer.parseInt(parts[0]));
            items[i].setWidth(Integer.parseInt(parts[1]));
            items[i].setName(i+1);
        }
    }

    public void ultimateScan(){
        Scanner s = new Scanner(System.in);
        height = s.nextInt();
        width = s.nextInt();
        itemNumber = s.nextInt();
        items = new Item[itemNumber];
        for (int i = 0; i < itemNumber; i++) {
            items[i] = new Item();
            items[i].setHeight(s.nextInt());
            items[i].setWidth(s.nextInt());
            items[i].setName(i + 1);
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
                if (j != width-1)System.out.print("\t");
            }
            if (i != height-1) System.out.print("\n");
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
    private Item getLargest(){
        Item largest = items[0];

        for (int i = 0; i<itemNumber; i++){
            if(items[i].getSize() > largest.getSize()){
                largest = items[i];
            }
        }
        return largest;
    }

    private void putItem(Item it,int y, int x){
        int i,j;
        int xo = x;
        for (i = 0; i<it.getHeight(); i++) {
            for (j = 0; j < it.getWidth(); j++) {
                bag[y][x] = it.getName();
                x++;
            }
            y++;
            x = xo;
        }
    }
    private boolean enoughSpace(Item it,int y,int x){
        int i,j;
        int xo = x;
        int size=0;
        for (i = 0; i<it.getHeight(); i++) {
            for (j = 0; j < it.getWidth(); j++) {
                if (x == width || y == height) return false;
                else {
                    if (bag[y][x] == 0) size++;
                    x++;
                }
            }
            y++;
            x = xo;
        }
        if (size == it.getSize()) return true;
        else return false;
    }

    public void insertItems(){
        for (int i = 0; i<itemNumber; i++){
            insert(items[i]);
        }
    }

    public void insert(Item it){
        int i,j;
        for (i = 0; i<height; i++) {
            for (j = 0; j < width; j++) {
               if (bag[i][j] == 0 && enoughSpace(it,i,j)){
                   putItem(it,i,j);
                   return;
               }
            }
        }
    }

    public void sort(){
        Item temp;
        boolean flag = true;

        while(flag) {
            flag = false;
            for (int i = 0; i < itemNumber-1; i++) {
                if (items[i].getMax() <= items[i+1].getMax()) {
                    if (items[i].getMax() == items[i + 1].getMax()) {
                        if (items[i].getMin() < items[i + 1].getMin()) {
                            temp = items[i];
                            items[i] = items[i + 1];
                            items[i + 1] = temp;
                            flag = true;
                        }
                    } else {
                        temp = items[i];
                        items[i] = items[i + 1];
                        items[i + 1] = temp;
                        flag = true;
                    }
                }
            }
        }
    }
    public void sort2(){
        Item temp;
        boolean flag = true;

        while(flag) {
            flag = false;
            for (int i = 0; i < itemNumber-1; i++) {
                if (items[i].getHeight() <= items[i+1].getHeight()) {
                    if (items[i].getHeight() == items[i + 1].getHeight()) {
                        if (items[i].getSize() < items[i + 1].getSize()) {
                            temp = items[i];
                            items[i] = items[i + 1];
                            items[i + 1] = temp;
                            flag = true;
                        }
                    } else {
                        temp = items[i];
                        items[i] = items[i + 1];
                        items[i + 1] = temp;
                        flag = true;
                    }
                }
            }
        }
    }

}
