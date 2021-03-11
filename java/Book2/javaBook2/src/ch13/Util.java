package ch13;

public class Util {
    public static <T> Box_<T> boxing(T t){
        Box_<T> box = new Box_<>();
        box.set(t);
        return box;
    }
}
