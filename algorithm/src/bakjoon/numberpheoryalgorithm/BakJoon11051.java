package bakjoon.numberpheoryalgorithm;

import java.util.Scanner;
// 이항 계수 2
public class BakJoon11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputA = sc.nextInt();
        int inputB = sc.nextInt();

        System.out.println(Combine(inputA,inputB) % 10007);
    }
    static int[][] check = new int[1001][1001];
    public static int Combine(int a,int b){
        if (a==b || b==0){
            return 1;
        }
        if (check[a][b] != 0){
            return check[a][b];
        }
        check[a-1][b-1] = Combine(a-1,b-1);
        check[a-1][b] = Combine(a-1,b);
        return check[a][b] = (check[a-1][b-1] + check[a-1][b])%10007;
    }
}