package ch11;

public class Member2 {
    private String id;
    private String name;

    public Member2(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return id + ": " + name;
    }
}
