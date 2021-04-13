package bakjoon.numberpheoryalgorithm;

import java.io.*;
import java.util.*;

public class BakJoon9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            int clothNum = Integer.parseInt(br.readLine());
            if (clothNum == 0) {
                bw.write(0 + "\n");
                continue; // 아 이거땜에 몇시간 날림 ㅡㅡ
            }
            Map<String, Integer> map = new HashMap<>();

            for (int cloth = 0; cloth < clothNum; cloth++) {
                st = new StringTokenizer(br.readLine());
                String clothName = st.nextToken(); // 필요없음
                String clothKind = st.nextToken(); // 옷의 종류

                // 있다면
                if (map.containsKey(clothKind)) {
                    int nowValue = map.get(clothKind);
                    map.put(clothKind, nowValue + 1);
                }
                // 없다면
                else {
                    map.put(clothKind, 1);
                }
            }
            int result = 1;
            for(int value : map.values()) {
                result = result * (value + 1);
            }
            bw.write(result - 1 + "\n"); // 알몸 제외
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
