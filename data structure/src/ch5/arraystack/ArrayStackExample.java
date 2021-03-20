package ch5.arraystack;

public class ArrayStackExample {
    public static void main(String[] args){
        ArrayStack stack = null;
        try {
            stack = new ArrayStack(6);
        }catch (IndexException e){
            e.printStackTrace();
            return;
        }
        stack.pushArrayStack('A');
        stack.pushArrayStack('B');
        stack.pushArrayStack('C');
        stack.pushArrayStack('D');
        stack.disPlayArrayStack();
        System.out.println();

        System.out.println("Pop 값-" + stack.popArrayStack());
        stack.disPlayArrayStack();
        System.out.println();

        System.out.println("Peek 값-" + stack.peekArrayStack());
        stack.disPlayArrayStack();
        System.out.println();

        stack.deleteArrayStack();
        stack.disPlayArrayStack();
    }
}
