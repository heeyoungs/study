package ch13;

public class BoxExample_ {
    public static void main(String[] args){
        Box_<String> box1 = new Box_<String>();
        box1.set("hello");
        String str = box1.get();

        Box_<Integer> box2 = new Box_<Integer>();
        box2.set(6);
        int value = box2.get();
    }
}
