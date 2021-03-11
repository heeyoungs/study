package ch8.p4;

public class MySqlDao implements DataAcessObject{
    @Override
    public void select(){
        System.out.println("MySql DB에서 검색");
    }
    @Override
    public void insert(){
        System.out.println("MySql DB에 삽입");
    }
    @Override
    public void update(){
        System.out.println("MySql DB에 수정");
    }
    @Override
    public void delete(){
        System.out.println("Mysql DB에서 삭제");
    }
}
