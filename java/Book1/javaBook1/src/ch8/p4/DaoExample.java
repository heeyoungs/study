package ch8.p4;

public class DaoExample {
    public static void dbWork(DataAcessObject dao){
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void main(String args[]){
        dbWork(new OracleDao());
        dbWork(new MySqlDao());
    }
}
