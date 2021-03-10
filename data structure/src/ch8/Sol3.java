package ch8;

public class Sol3 {
    public static void main(String[] args){
        recursive(5);
    }

    static void recursive(int n){
        if(n>1){
            recursive(n/2);
            recursive(n/2);
        }
        System.out.println(n);
    }
}

