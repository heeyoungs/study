package ch11;

public class MemberExample{
    public static void main(String[] args){
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if(obj1.equals(obj2)){
            System.out.println("obj1 == obj2");
        }
        else{
            System.out.println("obj1 /= obj2");
        }

        if(obj1.equals(obj3)){
            System.out.println("obj1 == obj3");
        }
        else{
            System.out.println("obj1 /= obj3");
        }
    }
}