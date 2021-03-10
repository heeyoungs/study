package ch11;

public class SystemEnvExample {
    public static void main(String args[]){
        String OS = System.getenv("OS");
        System.out.println("OS: "+OS);
    }
}
