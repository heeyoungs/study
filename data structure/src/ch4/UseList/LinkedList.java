package ch4.uselist;

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
            while(tempNode.getLink() != null){
                tempNode=tempNode.getLink();
            }
            tempNode.setLink(newNode);
        }
        currentCount++;
    }
    void addNode(int degree,double coef){
        DataBox dataBox = new DataBox(degree,coef);
        addNode(dataBox);
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
            if(tempNode.getData().getDegree() == 0) {
                System.out.print(tempNode.getData().getCoef());
            }else{
                System.out.print(tempNode.getData().getCoef() + "x^" + tempNode.getData().getDegree());
            }
            i++;
            tempNode = tempNode.getLink();

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
                int degreeA = ANode.getData().getDegree();
                int degreeB = BNode.getData().getDegree();
                if (degreeA > degreeB) {
                    coefSum = ANode.getData().getCoef();
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.getLink();
                } else if (degreeA == degreeB) {
                    coefSum = ANode.getData().getCoef() + BNode.getData().getCoef();
                    if(coefSum == 0){
                        ANode = ANode.getLink();
                        BNode = BNode.getLink();
                        break;
                    }
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.getLink();
                    BNode = BNode.getLink();
                } else {
                    coefSum = BNode.getData().getCoef();
                    newList.addNode(degreeB, coefSum);
                    BNode = BNode.getLink();
                }
            }
            while (ANode != null) {
                coefSum = ANode.getData().getCoef();
                newList.addNode(ANode.getData().getDegree(), coefSum);
                ANode = ANode.getLink();
            }
            while (BNode != null) {
                coefSum = BNode.getData().getCoef();
                newList.addNode(BNode.getData().getDegree(), coefSum);
                BNode = BNode.getLink();
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
                int degreeA = ANode.getData().getDegree();
                int degreeB = BNode.getData().getDegree();
                if (degreeA > degreeB) {
                    coefSum = ANode.getData().getCoef();
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.getLink();
                } else if (degreeA == degreeB) {
                    coefSum = ANode.getData().getCoef() - BNode.getData().getCoef();
                    if(coefSum == 0){
                        ANode = ANode.getLink();
                        BNode = BNode.getLink();
                        break;
                    }
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.getLink();
                    BNode = BNode.getLink();
                } else {
                    coefSum = -BNode.getData().getCoef();
                    newList.addNode(degreeB, coefSum);
                    BNode = BNode.getLink();
                }
            }
            while (ANode != null) {
                coefSum = ANode.getData().getCoef();
                newList.addNode(ANode.getData().getDegree(), coefSum);
                ANode = ANode.getLink();
            }
            while (BNode != null) {
                coefSum = -BNode.getData().getCoef();
                newList.addNode(BNode.getData().getDegree(), coefSum);
                BNode = BNode.getLink();
            }
        }
        else{
            System.out.println("오류");
        }

        return newList;
    }
}
