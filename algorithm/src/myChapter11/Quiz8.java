package myChapter11;

import java.util.List;
import java.util.*;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //    @Override
    public String toString() {
        return String.format("%s(%s)", this.name, this.age);
    }
}

/*list.sort(new Comparator<User>() {

	@Override

	public int compare(User o1, User o2) {

		return o1.getAge() - o2.getAge();

	}

});*/
public class Quiz8 {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("홍길동", 20));
        list.add(new User("아무개", 25));
        list.add(new User("무지개", 21));
        list.add(new User("김린지", 24));
        list.add(new User("호호호", 29));

        System.out.println(list); // 그냥 출력
        list.sort((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(list); // 성적 대로 출력 1~100
        list.sort((n1, n2) -> n1.getName().compareTo(n2.getName()));
        System.out.println(list); // 이름 순서대로 가-하

        TreeSet<User> set = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName())); // 저장할때 이름 순
        set.add(new User("홍길동", 20));
        set.add(new User("아무개", 25));
        set.add(new User("무지개", 21));
        set.add(new User("김린지", 24));
        set.add(new User("호호호", 29));
        System.out.println(set);

        TreeSet<User> set1 = new TreeSet<>((a1, a2) -> a1.getAge() - a2.getAge()); // 저장할때 성적 순
        set1.add(new User("홍길동", 20));
        set1.add(new User("아무개", 25));
        set1.add(new User("무지개", 21));
        set1.add(new User("김린지", 24));
        set1.add(new User("호호호", 29));
        System.out.println(set1);
    }
}