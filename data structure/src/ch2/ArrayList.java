package ch2;

public class ArrayList {
    ArrayList(int count) {
        this.currentCount = 0;
        this.maxCount = count;
        this.element = new int[count];
    }
    int currentCount;
    int maxCount;
    int[] element = null;

    public void addListData(int position,int value)throws PositionException{ // 추가
        if(position<0){
            throw new PositionException("0보다 작은 인덱스");
        }
        else if(position>currentCount) {
            throw new PositionException("현재 자료개수 보다 큰 인덱스");
        }
        //맨 마지막
        else if(position == currentCount) {
            element[currentCount] = value;
            currentCount++;
        }
        //처음 or중간에 삽입
        else if(position>=0 && position< currentCount){
            for(int i=currentCount;i>=position;i--){
                element[i+1] = element[i];
            }
            element[position] = value;
            currentCount++;
        }
        //
    }
    public void removeListData(int position)throws PositionException{ // 제거
        if(position<0){
            throw new PositionException("0보다 작은 인덱스");
        }
        // 값 제거
        else if(position >= 0 && position <= currentCount){
            for(int i=position;i<currentCount;i++){
                element[i] = element[i+1];
            }
            currentCount--;
        }
    }
    int getListData(int position){ // 값 가져오기
        return element[position];
    }
    int getListLength(){ // 길이 가져오기
        return currentCount;
    }
    public void clearList(){ // 리스트 초기화
        for(int i=0;i<currentCount;i++){
            element[i] = 0;
            currentCount--;
        }
    }
}
