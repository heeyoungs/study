package ch13;

public class Person{
    protected String name;
    Person(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
