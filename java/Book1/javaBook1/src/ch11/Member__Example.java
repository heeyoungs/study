package ch11;

public class Member__Example {
    public static void main(String args[]){
        // 원복 객체 생성
        Member__ orginal = new Member__("홍길동", 25,new int[]{90,90},new Car("소나타"));

        // 복제 객체를 얻은 후에 참조 객체의 값을 변경
        Member__ cloned = orginal.getMember();
        cloned.scores[0] = 100;
        cloned.car.model = "그렌져";

        System.out.println("[복제 객체의 필드값]");
        System.out.println("name: " + cloned.name);
        System.out.println("age: " + cloned.age);
        System.out.print("scores: {");
        for (int i = 0;i<cloned.scores.length;i++){
            System.out.print(cloned.scores[i]);
            System.out.print((i==(cloned.scores.length-1))?"":",");
        }
        System.out.println("}");
        System.out.println("car: " + cloned.car.model);

        System.out.println();

        System.out.println("[원본 객체의 필드값]");
        System.out.println("name: " + orginal.name);
        System.out.println("age: " + orginal.age);
        System.out.print("scores: {");
        for (int i = 0;i<orginal.scores.length;i++){
            System.out.print(orginal.scores[i]);
            System.out.print((i==(orginal.scores.length-1))?"":",");
        }
        System.out.println("}");
        System.out.println("car: " + orginal.car.model);
    }
}
