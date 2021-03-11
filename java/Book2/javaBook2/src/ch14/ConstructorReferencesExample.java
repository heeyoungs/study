package ch14;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {
    public static void main(String[] args){
        Function<String,Member_>function1 = Member_ :: new;
        Member_ member1 = function1.apply("angel");

        BiFunction<String,String,Member_>function2 = Member_ :: new;
        Member_ member2 = function2.apply("신천사","angel");
    }
}
