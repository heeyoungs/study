package ch13;

public class BoxExample {
    public static void main(String[] args){
        Box box = new Box();
        box.set("홍길동");
        String name = (String)box.get();

        box.set(new Apple());
        Apple apple = (Apple) box.get();
    }
}
