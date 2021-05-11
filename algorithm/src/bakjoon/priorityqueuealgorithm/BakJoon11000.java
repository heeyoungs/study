package bakjoon.priorityqueuealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 강의실 배정
public class BakJoon11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;
        StartEnd[] se = new StartEnd[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            se[i] = new StartEnd(start, end);
        }
        Arrays.sort(se, new Comparator<StartEnd>() {
            @Override
            public int compare(StartEnd o1, StartEnd o2) {
                return o1.start - o2.start;
            }
        });
        queue.add(se[0].end);
        for (int i = 1; i < N; i++) {
            if (se[i].start >= queue.peek()){
                queue.poll();
                queue.add(se[i].end);
            }else{
                queue.add(se[i].end);
            }
        }
        System.out.println(queue.size());
    }

    static class StartEnd {
        int start;
        int end;

        StartEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/*
1. 입력받아서 일찍 시작하는 순서대로 정렬한다.
2. 우선순위 큐에 넣을 값은 그 수업의 끝나는 시간
3. 우선순위 큐의 맨 위에는 현재 수업중인 수업들중에 가장 빨리 끝날 수업의 값이 들어있겠죠?
4. 그 수업이 현재 보는 수업의 시작 시간보다 빨리 끝나는지 늦게 끝나는지 비교
    => 그 수업이 현재 보는 수업의 시작 시간보다 빨리 끝난다! 그 수업을 poll 하고 인큐
    => 그 수업이 현재 보는 수업의 시작 시간보다 느리게 끝난다! 그 수업을 그냥 인큐 (강의실 개수 하나 증가)
5. 큐의 크기가 총 강의실의 사용 개수이겠죠?
 */
