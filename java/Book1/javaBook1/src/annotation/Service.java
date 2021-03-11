package annotation;

public class Service{
    @PrintAnnotation
    public void method1(){
        System.out.println("실1");
    }
    @PrintAnnotation("*")
    public void method2(){
        System.out.println("실2");
    }
    @PrintAnnotation(value="*",number=20)
    public void method3(){
        System.out.println("실3");
    }
}