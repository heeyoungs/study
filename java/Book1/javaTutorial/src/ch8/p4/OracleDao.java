package ch8.p4;

public class OracleDao implements DataAcessObject{
    @Override
    public void select(){
        System.out.println("Oracle DB에서 검색");
    }
    @Override
    public void insert(){
        System.out.println("Oracle DB에 삽입");
    }
    @Override
    public void update(){
        System.out.println("Oracle DB에 수정");
    }
    @Override
    public void delete(){
        System.out.println("Oracle DB에서 삭제");
    }
}
