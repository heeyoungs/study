package ch11;

public class Member1 implements Comparable<Member1>{
    String name;
    Member1(String name){
        this.name = name;
    }
    @Override
    public int compareTo(Member1 o){
        return name.compareTo(o.name);
    }
}
