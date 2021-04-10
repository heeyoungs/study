//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int inputNum = Integer.parseInt(br.readLine());
//
//        long num = factorial(inputNum);
//
//        int count = 0;
//
//        do {
//            if (num % 10 == 0) {
//                count++;
//                num = num / 10;
//            } else {
//                break;
//            }
//        } while (true);
//        bw.write(count + "");
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    public static int factorial(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return factorial(n - 1) * n;
//    }
//}
