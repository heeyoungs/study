package sourcecode.sort;

import java.util.Random;
import java.util.Scanner;

public class Algorithm5Week {
    public static void main(String[] args) {
        int DataSet[] = new int[10];
        int Length = 10;
        int i;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        for (i = 0; i < Length; i++) {
            DataSet[i] = random.nextInt(100);
        }
        System.out.println("정렬 전");
        for (i = 0; i < Length; i++) {
            System.out.print(DataSet[i] + " ");
        }

        System.out.print("\n1.병합 정렬 / 2.퀵 정렬 / 3.힙 정렬\n선택 : ");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.print("병합 정렬 ");
                mergeSort(DataSet, 0, Length - 1);
                break;
            case 2:
                System.out.print("퀵 정렬 ");
                quickSort(DataSet,0,Length-1);
                break;
            case 3:
                System.out.print("힙 정렬 ");
                heapSort(DataSet);
                break;
            default:
                System.out.println("잘못된 입력값");
                return;
        }

        System.out.println("정렬 후");
        for (i = 0; i < Length; i++) {
            System.out.print(DataSet[i] + " ");
        }
    }

    static int arrayCopy[] = new int[10]; // 병합 정렬용
    static void mergeSort(int[] array, int start, int end) {
        if (start < end) { // start가 end보다 작은 경우!
            int middle = (start + end) / 2;
            mergeSort(array, start, middle); // start 부터 middle까지 재귀 -> 계속 분해
            mergeSort(array, middle + 1, end); // middle+1부터 end까지 재귀 -> 계속 분해
            merge(array, start, middle, end); // -> 병합
        }
    } // 분해 -> 병합

    static void merge(int[] array, int start, int middle, int end) {
        int i = start; // i는 잘린 앞 배열의 첫 인덱스
        int j = middle + 1; // j는 잘린 뒷 배열의 첫 인덱스
        int k = start; // k는 arrayCopy의 인덱스

        while (i <= middle && j <= end) { // i가 middle값까지 커지거나 j가 end값까지 작아질때까지 반복
            // 앞 배열과 뒷 배열의 값을 인덱스를 하나씩 올려가면서 비교하고 arrayCopy에 집어넣는 과정이다!!
            if (array[i] > array[j]) { // 뒷 배열의 원소가 앞 배열의 원소보다 작은 경우
                arrayCopy[k] = array[i]; // 앞 배열의 원소를 arrayCopy에 넣고
                i++; // 앞 배열의 다음 원소를 가리키게함
            } else { // 반대일 경우!
                arrayCopy[k] = array[j];
                j++;
            }
            k++;
        }
        // 후처리 / 위 과정을 마치면 i나 j둘중에 하나는 복사되지 않은 원소들이 존재
        if (j > end) { // 만약 i에 원소가 남았다면
            while (i <= middle) { // i가 middle을 가리킬떄까지
                arrayCopy[k] = array[i]; // arrayCopy에 array[i]값을 넣고
                i++;
                k++; // i와 k값을 계속 증가 시킴
            }
        } else { // 반대일 경우!!
            while (j <= end) {
                arrayCopy[k] = array[j];
                j++;
                k++;
            }
        }
        for (int t = start; t <= end; t++) { // arrayCopy에 저장된 start부터 end인덱스까지의 값을 array에 복사
            array[t] = arrayCopy[t];
        }
    } // 정렬

    static void quickSort(int[] array,int start, int end){
        int pivot = start; // 피벗을 첫 번째 지점으로 설정
        int i = start +1; // 피벗의 다음 인덱스
        int j = end; // 마지막 인덱스
        int temp; // 교환 상자

        while(i<=j){ // i와 j가 엇갈릴떄까지 반복
            while(i <= end && array[i] > array[pivot]){ // 피벗 값보다 작은 값을 만날 때까지 오른쪽으로 이동
                i++;
            }
            while(j > start && array[j] <= array[pivot]){ // 피벗 값보다 크거나 같은 값을 만날 때까지 왼쪽으로 이동
                j--;
            }
            if(i>j){ // 엇갈렸다면 작은 값과 피벗을 교환 -> 피벗이 재위치한 자리는 자기 자리
                temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;
            } else{ // 엇갈리지 않았다면 i인덱스 값과 j인덱스 값 교환
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            quickSort(array,start,j-1); // start부터 피벗이 위치한 값 보다 한칸 적은 값을 재귀
            quickSort(array,j+1,end); // 피벗이 위치한 값보다 한칸 큰 값부터 end까지를 재귀
        }
    }

    static void heapSort(int[] array) {
        // 최소 힙을 구성
        for (int i = 0; i < array.length - 1; i++) {
            int c = i; // c는 자식 노드를 가리킴
            do {
                int root = (c - 1) / 2; // 부모 노드설정 -> 자식노드/2
                if (array[root] > array[c]) { // 자식 노드의 값이 부모노드보다 작으면 교환
                    int temp = array[root];
                    array[root] = array[c];
                    array[c] = temp;
                }
                c = root; // c가 가리키는 값을 현재 c의 부모로 바꿔줌
            } while (c != 0); // 만약 c가 루트 노드 값까지 올라가서 교환되면, 반복문을 빠져나옴
        }

        // 크기를 줄여가며 반복적으로 힙을 구성 -> 가장 작은 값을 맨 뒤로 보낸다.
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0]; // 힙의 루트 노드값을 배열의 맨 뒤로 보냄
            array[0] = array[i];
            array[i] = temp; // 여기까지
            int root = 0; // 부모 노드를 가리킬 변수
            int c = 1; // 자식 노드를 가리킬 변수
            do {
                c = 2 * root + 1; // 현재 root변수의 자식 노드 설정
                // 자식 중에 더 작은 값을 찾기
                if (c < i - 1 && array[c] > array[c + 1]) {
                    c++;
                }
                // 루트보다 자식이 더 작다면 교환
                if (c < i && array[root] > array[c]) {
                    temp = array[root];
                    array[root] = array[c];
                    array[c] = temp;
                }
                root = c; // root가 가리키는 값을 현재 root의 자식으로 바꿔줌
            } while (c < i); // 배열의 끝까지 가면서
        }
    }
}
