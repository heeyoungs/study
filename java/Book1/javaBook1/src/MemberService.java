public class MemberService {
    public String id = "hong";
    public String password = "12345";

    boolean login(String id,String password){
        if(this.id.equals("hong")&&this.password.equals("12345")){
            return true;
        }
        else{
            return false;
        }
    }
    void logout(String id){
        if(this.id.equals("hong")){
            System.out.println("로그아웃 되었습니다.");
        }
    }
}
// 6장 15번