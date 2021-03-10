package ch2;

public class ArrayListExample {
    public static void main(String[] args){
        ArrayList pList = new ArrayList(5);

        try {
            pList.addListData(0, 10);
            pList.addListData(1, 20);
            pList.addListData(2, 30);
        }catch (PositionException e){ e.printStackTrace();return; }

        int value = pList.getListData(1);
        System.out.println("1 위치의 값 : " + value);

        try { pList.removeListData(0); }catch (PositionException e){ e.printStackTrace();return; }

        System.out.println("리스트의 길이 : " + pList.getListLength());
    }
}