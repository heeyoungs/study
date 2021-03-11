package ch11;

public class Member_ implements Cloneable{
    public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;

    public Member_(String id, String name, String password, int age, boolean adult){
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.adult = adult;
    }

    public Member_ getMember(){
        Member_ cloned = null;

        try{
            cloned = (Member_) clone();
        }catch (CloneNotSupportedException e){}
        return cloned;
    }
}
