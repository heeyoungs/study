package ch8;

public class Sol2 {
    public static void main(String[] args){
        System.out.println(factorial(5));
    }

    static int factorial(int n){
        int ret = 1;
        if(n==1){
            return ret;
        }
        ret = n * factorial(n - 1);
        return ret;
    }
}
