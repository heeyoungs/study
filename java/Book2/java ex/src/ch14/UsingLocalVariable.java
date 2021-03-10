package ch14;

public class UsingLocalVariable {
    void method(int arg){
        int localVar = 40;

        MyFunctionalInterface fi =()->{
            System.out.println("arg: " + arg);
            System.out.println("local: " + localVar + "\n");
        };
        fi.method();
    }
}
