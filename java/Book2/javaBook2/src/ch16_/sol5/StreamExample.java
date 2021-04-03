package ch16_.sol5;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args){
        List<String> list = Arrays.asList(
                "This is a java Book",
                "Lambda Expressions",
                "Java8 supports lambda expressions"
        );

        list.stream().filter(n -> n.contains("java")).forEach(a->System.out.println(a));
    }
}
