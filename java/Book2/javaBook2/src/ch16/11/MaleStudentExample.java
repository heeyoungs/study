package chap16.src.sec11.stream_collect;

import java.util.Arrays;
import java.util.List;

public class MaleStudentExample {
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("ȫ�浿", 10, Student.Sex.MALE),
				new Student("�����", 6, Student.Sex.FEMALE),
				new Student("�ſ��", 10, Student.Sex.MALE),
				new Student("�ڼ���", 6, Student.Sex.FEMALE)
		);
		
		MaleStudent maleStudent = totalList.stream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				//.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine); 
				.collect(()->new MaleStudent(), (r, t)->r.accumulate(t), (r1, r2)->r1.combine(r2));
		
		maleStudent.getList().stream()
			.forEach(s -> System.out.println(s.getName()));
	}
}
