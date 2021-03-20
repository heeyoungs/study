package ch5.arraystack;

public class ArrayStack{
    private int currentCount;
    private int maxCount;
    private ArrayStackNode[] element = null;
    ArrayStack(int count) throws IndexException{ // 배열 스택 생성자
        if(count < 0 ){
            throw new IndexException("0보다 작은 숫자가 입력됨");
        }
        this.currentCount = 0;
        this.maxCount = count;
        this.element = new ArrayStackNode[count];
        for (int i = 0; i < count; i++) {
            element[i] = new ArrayStackNode();
        }
    } // 5장 5번 문제
    int pushArrayStack(char data){
        if(currentCount == maxCount){ // 유효성 점검, 배열이 꽉찼는지
            return -1;
        }
        element[currentCount].setData(data);
        currentCount++;
        return 1;
    }
    char peekArrayStack(){
        ArrayStackNode temp = null;
        if(isArrayStackEmpty() == 1) { // 유효성 검사,배열이 비었는지
            return 'n';
        }
        temp = element[currentCount-1];
        return temp.getData();
    }
    char popArrayStack(){
        ArrayStackNode temp = null;
        char data;
        if(isArrayStackEmpty() == 1){ // 유효성 검사,배열이 비었는지
            return 'n';
        }
        temp = element[currentCount-1];
        data = temp.getData();
        currentCount--;
        element[currentCount].setData('0');
        return data;
    }
    void deleteArrayStack(){
        if(isArrayStackEmpty() == 1) return;
        while(true) {
            currentCount--;
            element[currentCount].setData('0');
            if(currentCount == 0){ break; }
        }
    }
    int isArrayStackEmpty(){
        if(currentCount == 0){ return 1; }
        return -1;
    }
    void disPlayArrayStack(){
        System.out.println("스택 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
        for(int i = maxCount-1;i >= currentCount ;i--){
            System.out.println(i + "-" + "Empty");
        }
        for(int i = currentCount-1;i>=0;i--){
            System.out.println(i + "-" + element[i].getData());
        }
    }
}
