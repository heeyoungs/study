package ch14;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args){
        MyFunctionalInterface fi;

        fi = ()->{
            String str = "method call1";
            System.out.println(str);
        };
        fi.method();

        fi = ()->{
            System.out.println("method call2");
        };
        fi.method();

        fi = ()->System.out.println("mathod call3");
        fi.method();
    }
}
