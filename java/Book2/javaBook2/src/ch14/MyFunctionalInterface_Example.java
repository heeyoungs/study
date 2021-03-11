package ch14;

public class MyFunctionalInterface_Example {
    public static void main(String[] args){
        MyFunctionalInterface_ fi;

        fi = (x)->{
            int result = x * 5;
            System.out.println(result);
        };
        fi.method(2);

        fi = (x)->{
            System.out.println(x*5);
        };
        fi.method(2);

        fi=x->System.out.println(x*5);
        fi.method(2);
    }
}
