package ch15;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
    public static void main(String[] args){
        List<String> list1 = Arrays.asList("홍길동","신용권","김자바");
        for(String names: list1){
            System.out.println(names);
        }

        List<Integer> list2 = Arrays.asList(1,2,3);
        for(int value : list2){
            System.out.println(value);
        }
    }
}
