package sourcecode.search;

import java.util.Random;
import java.util.Scanner;

public class Select {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = sc.nextInt(); // 자연수의 개수
        int i = sc.nextInt(); // i번째 작은 수

        System.out.print("정렬 전: ");
        int[] array = new int[n]; // n크기 만큼의 배열을 생성해 줍니다.
        for (int k = 0; k < n; k++) { // 난수를 입력받고 초기화 해줍니다.
            array[k] = random.nextInt(100) + 1;
            System.out.print(array[k] + " "); // 입력받은 난수를 출력합니다.
        }


        System.out.print("\n" + i + "번째 작은 수: " + select(array, 0, n - 1, i));
    }

    static int select(int[] data, int start, int end, int findPoint) {
        if (start == end) { // 쪼개질때 까지 쪼개졌으면
            return data[start]; // 그 자리에 값이 있는 거니깐 값을 반환
        }
        int q = partition(data, start, end); // partition 함수를 호출해 받은 인덱스 q의 앞부분은 다 정렬되어 있는 상태
        int k = q - start + 1; // q가 전체에서 k번 번째 작은 숫자임을 의미

        if (findPoint < k) { // 찾는 위치가 k보다 작으면
            return select(data, start, q - 1, findPoint); // q를 기준으로 앞부분을 select 재귀
        } else if (findPoint > k) { // 찾는 위치가 k보다 크면
            return select(data, q + 1, end, findPoint - k); // q를 기준으로 뒷부분을 select 재귀
        } else { // k가 찾는 위치
            return data[q]; // 그 자리의 값을 반환
        }
    }

    static int partition(int[] data, int start, int end) {
        int pivot = data[end]; // 피벗 값을 데이터의 맨 마지막 값으로 지정합니다.
        int i = start - 1; // start 의 앞부분을 찍어줍니다.
        int temp; // 교환상자
        for (int j = start; j <= end - 1; j++) { // start 부터 피벗의 앞 부분인 end-1까지의 값을 검사합니다.
            if (data[j] <= pivot) { // 반복문이 돌아갈 때 현재 값보다 피벗 값이 더 크거나 같으면
                i += 1; // i는 start 부분(start 부터 뒤로 한 칸씩) , j는 피벗보다 작은 값이 위치하는 부분
                temp = data[i]; //
                data[i] = data[j];
                data[j] = temp; // 둘의 위치를 바꿔줍니다.
            } // i
        }
        temp = data[i + 1];
        data[i + 1] = data[end];
        data[end] = temp; // 현재 위치한 자리의 다음 값과 피벗 값을 바꿔줍니다.
        return i + 1;
        // 그 다음 인덱스를 반환합니다 -> 인덱스 i + 1 을 기준으로 앞부분은 i + 1보다 작은 값들의 모임, 뒷부분은 i + 1 보다 큰 값들의 모임
    }
}
