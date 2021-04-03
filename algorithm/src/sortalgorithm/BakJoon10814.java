package sortalgorithm;

import java.util.*;

public class BakJoon10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        Vector<Person> vector = new Vector<>();
        int age;
        String name;
        for(int i=0;i<inputNum;i++){
            age = sc.nextInt();
            name = sc.next();
            Person person = new Person(age,name);
            vector.add(person);
        }

        Collections.sort(vector, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() > o2.getAge()){
                    return 1;
                } else if (o1.getAge() < o2.getAge()){
                    return -1;
                } else{
                    return 0;
                }
            }
        });

        for(int i=0;i<inputNum;i++){
            System.out.println(vector.get(i).getAge() + " " + vector.get(i).getName());
        }


    }
    // 사람 정보 클래스
    public static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
