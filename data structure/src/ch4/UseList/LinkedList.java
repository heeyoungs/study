package ch4.UseList;

import ch3.SingleLinkedList.PositionException;

public class LinkedList {
    private LinkedListNode head;
    private int currentCount;
    LinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
    void addNode(DataBox data){
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode tempNode = head;
        if(head==null){
            head = newNode;
        }
        else{
            while(tempNode.link != null){
                tempNode=tempNode.link;
            }
            tempNode.link = newNode;
        }
        currentCount++;
    }
    void addNode(int degree,double coef){
        DataBox dataBox = new DataBox(degree,coef);
        addNode(dataBox);
    }
    void removeNode(int index)throws PositionException{
        LinkedListNode tempNode = head;
        LinkedListNode tempPreNode = null;
        if(index < 0 || index > currentCount-1) {
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){
            tempNode = tempNode.link;
            this.head = tempNode;
        }
        else{
            for(int i=0;i<index;i++){
                tempPreNode= tempNode;
                tempNode=tempNode.link;
            }
            tempPreNode.link = tempNode.link;
        }
        currentCount--;
    }
    DataBox getLinkedListData(int index)throws PositionException{
        LinkedListNode tempNode = head;
        if(index > currentCount-1){
            throw new PositionException("인덱스 에러");
        }
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.data;
    }
    int getLinkedListLength(){
        return currentCount;
    }
    void disPlayLinkedList(){
        LinkedListNode tempNode = head;
        int i = 0;
        if(head == null){
            System.out.println("자료가 없습니다.");
            return;
        }
        while(tempNode!=null){
            if(i>0){
                System.out.print(" + ");
            }
            if(tempNode.data.degree == 0) {
                System.out.print(tempNode.data.coef);
            }else{
                System.out.print(tempNode.data.coef + "x^" + tempNode.data.degree);
            }
            i++;
            tempNode = tempNode.link;

        }
        System.out.println();
    }
    LinkedList AddList(LinkedList pList){
        double coefSum = 0;
        LinkedList newList = new LinkedList();
        LinkedListNode ANode = head;
        LinkedListNode BNode = pList.head;

        if(ANode != null && BNode != null) {
            while (ANode != null && BNode != null) {
                int degreeA = ANode.data.degree;
                int degreeB = BNode.data.degree;
                if (degreeA > degreeB) {
                    coefSum = ANode.data.coef;
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                } else if (degreeA == degreeB) {
                    coefSum = ANode.data.coef + BNode.data.coef;
                    if(coefSum == 0){
                        ANode = ANode.link;
                        BNode = BNode.link;
                        break;
                    }
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                    BNode = BNode.link;
                } else {
                    coefSum = BNode.data.coef;
                    newList.addNode(degreeB, coefSum);
                    BNode = BNode.link;
                }
            }
            while (ANode != null) {
                coefSum = ANode.data.coef;
                newList.addNode(ANode.data.degree, coefSum);
                ANode = ANode.link;
            }
            while (BNode != null) {
                coefSum = BNode.data.coef;
                newList.addNode(BNode.data.degree, coefSum);
                BNode = BNode.link;
            }
        }
        else{
            System.out.println("오류");
        }

        return newList;
    }
    LinkedList SubList(LinkedList pList){
        LinkedList newList = new LinkedList();
        double coefSum = 0;
        LinkedListNode ANode = head;
        LinkedListNode BNode = pList.head;

        if(ANode != null && BNode != null) {
            while (ANode != null && BNode != null) {
                int degreeA = ANode.data.degree;
                int degreeB = BNode.data.degree;
                if (degreeA > degreeB) {
                    coefSum = ANode.data.coef;
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                } else if (degreeA == degreeB) {
                    coefSum = ANode.data.coef - BNode.data.coef;
                    if(coefSum == 0){
                        ANode = ANode.link;
                        BNode = BNode.link;
                        break;
                    }
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                    BNode = BNode.link;
                } else {
                    coefSum = -BNode.data.coef;
                    newList.addNode(degreeB, coefSum);
                    BNode = BNode.link;
                }
            }
            while (ANode != null) {
                coefSum = ANode.data.coef;
                newList.addNode(ANode.data.degree, coefSum);
                ANode = ANode.link;
            }
            while (BNode != null) {
                coefSum = -BNode.data.coef;
                newList.addNode(BNode.data.degree, coefSum);
                BNode = BNode.link;
            }
        }
        else{
            System.out.println("오류");
        }

        return newList;
    }
}
