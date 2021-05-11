package ch12.indexsequentialsearch;

public class SimpleIndexNode {
    private int position;
    private int key;
    public void setPosition(int position){
        this.position = position;
    }
    public void setKey(int key){
        this.key = key;
    }
    public int getPosition(){
        return position;
    }
    public int getKey(){
        return key;
    }
}
