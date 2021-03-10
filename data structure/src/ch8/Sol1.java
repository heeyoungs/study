package ch8;

public class Sol1 {
    public static void main(String[] args){
        System.out.println(factorial(5));
    }

    static int factorial(int n){
        int ret = 0;
        if(n>=1){
            ret=n*factorial(n-1);
        }
        else {
            ret=1;
        }
        return ret;
    }
}
