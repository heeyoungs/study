package ch12.indexsequentialsearch;

public class SimpleIndexNode {
    private int position;
    private int key;
    void setPosition(int position){
        this.position = position;
    }
    void setKey(int key){
        this.key = key;
    }
    int getPosition(){
        return position;
    }
    int getKey(){
        return key;
    }
}
