import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개의 수를 입력하실 건가요: ");
        int num = sc.nextInt();

        int[] input = new int[num];

        System.out.println(num + "개의 수를 입력해 주세요!");
        for(int i=0;i<num;i++){
            input[i] = sc.nextInt();
        }
        int big = input[0];

        for(int i=1;i<num;i++){
            if(big<input[i]){
                big = input[i];
            }
        }
        System.out.println(big);
    }
}
