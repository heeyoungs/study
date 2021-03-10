package ch11;

public class Member{
    public String id;

    public Member(String id){
        this.id = id;
    }
    @Override
    public boolean equals(Object obj){ // equals 메소드의 오버라이딩
        if(obj instanceof Member){ // 기준 객체가 동일한 타입인지 확인해 줘야 한다.
            Member member = (Member) obj; // Member타입으로 강제 타입 변환하고 id 필드값이 동일한지 검사, 동일하면 true
            if(id.equals(member.id)){
                return true;
            }
        }
        return false; // Member타입이 아니거나 동일하지 않으면 false
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
}