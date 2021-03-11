package ch13;

public class Box_ingMethodExample {
    public static void main(String[] args){
        Box_<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.get();

        Box_<String> box2 = Util.boxing("홍길동");
        String strValue = box2.get();
    }
}
