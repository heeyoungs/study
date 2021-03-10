package ch9;

public class A {
    class B{} // 인스턴스 멤버 클래스
    static class C{} // 정적 멤버 클래스

    B field1 = new B();
    C field2 = new C();

    void method1(){
        B var1 = new B();
        C var2 = new C();
    }

    //static B field3 = new B(); x
    static C field4 = new C();

    static void method2(){
        //B var1 = new B(); x
        C var2 = new C();
    }
}
