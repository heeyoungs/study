package ch13;

public class BoundedTypeParameterExample {
    public static void main(String[] args){
        int result1 = Util__.compare(10,20);
        System.out.println(result1);

        int result2 = Util__.compare(4.5,3);
        System.out.println(result2);
    }
}
