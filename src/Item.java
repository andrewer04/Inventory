
public class Item {
    private int height;
    private int width;
    private int name;

    public void setHeight(int h){
        height = h;
    }
    public void setWidth(int w){
        width = w;
    }
    public void setName(int name) {
        this.name = name;
    }

    public int getHeight(){
        return height;
    }
    public int getWidth(){ return width;    }
    public int getName() {
        return name;
    }

    public int getSize(){
        return height * width;
    }
    public int getMax() { return (height > width) ? height : width;}
    public int getMin() { return (height < width) ? height : width;}
}
