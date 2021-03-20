package ch4.uselist;

public class LinkedListExample {
    public static void main(String[] args){
        LinkedList AList = new LinkedList();
        AList.addNode(6,7);
        AList.addNode(new DataBox(5,3));
        AList.addNode(new DataBox(2,5));
        AList.disPlayLinkedList();

        LinkedList BList = new LinkedList();
        BList.addNode(5,1);
        BList.addNode(4,2);
        BList.addNode(2,-5);
        BList.addNode(0,4);
        BList.disPlayLinkedList();

        LinkedList A = new LinkedList();
        A = AList.AddList(BList);
        A.disPlayLinkedList();

        LinkedList B = new LinkedList();
        B = AList.SubList(BList);
        B.disPlayLinkedList();

    }
}
