package ch5.linkedstack;

public class LinkedStackExample {
    public static void main(String[] args){
        LinkedStack stack = new LinkedStack();
        stack.pushLinkedStack('A');
        stack.pushLinkedStack('B');
        stack.pushLinkedStack('C');
        stack.pushLinkedStack('D');
        stack.disPlayLinkedStack();
        System.out.println();

        System.out.println("Pop-" + stack.popLinkedStack().getData());
        stack.disPlayLinkedStack();
        System.out.println();

        System.out.println("Peek-" + stack.peekLinkedStack().getData());
        stack.disPlayLinkedStack();
        System.out.println();

        stack.deleteLinkedStack();
        stack.disPlayLinkedStack();
    }
}
