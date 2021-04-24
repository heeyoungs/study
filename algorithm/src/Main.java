import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = a;
            ans = ans % 10;
            for (int i = 1; i < b; i++) {
                ans = ans * a;
                ans = ans%10;
            }
            if (ans == 0){
                sb.append(10 + "\n");
            }else {
                sb.append(ans + "\n");
            }
        }
        System.out.print(sb);
    }
}
