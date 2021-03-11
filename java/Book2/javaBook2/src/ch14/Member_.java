package ch14;

public class Member_ {
    private String name;
    private String id;

    public Member_(){
        System.out.println("Member() 실행");
    }
    public Member_(String id){
        System.out.println("Member(String id) 실행");
        this.id = id;
    }
    public Member_(String name,String id){
        System.out.println("Member(String name, String id)");
        this.name = name;
        this.id = id;
    }
}
