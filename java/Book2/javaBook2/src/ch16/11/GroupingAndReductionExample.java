package chap16.src.sec11.stream_collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingAndReductionExample {
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("ȫ�浿", 10, Student.Sex.MALE),
				new Student("�����", 12, Student.Sex.FEMALE),
				new Student("�ſ��", 10, Student.Sex.MALE),
				new Student("�ڼ���", 12, Student.Sex.FEMALE)
		);
		
		//������ ��� ������ �����ϴ� Map ���
		Stream<Student> totalStream = totalList.stream();
		Function<Student, Student.Sex> classifier = Student :: getSex;
		ToDoubleFunction<Student> mapper = Student :: getScore;
		Collector<Student, ?, Double> collector1 = Collectors.averagingDouble(mapper);
		Collector<Student, ?, Map<Student.Sex, Double>> collector2 = Collectors.groupingBy(classifier, collector1);
		Map<Student.Sex, Double> mapBySex = totalStream.collect(collector2);
		
		/*Map<Student.Sex, Double> mapBySex = totalList.stream()
				.collect(
					Collectors.groupingBy(
						Student :: getSex, 
						Collectors.averagingDouble(Student :: getScore)
					)
				);*/
		
		System.out.println("���л� ��� ����: " + mapBySex.get(Student.Sex.MALE));
		System.out.println("���л� ��� ����: " + mapBySex.get(Student.Sex.FEMALE));
		
		//������ ��ǥ�� ���е� �̸��� �����ϴ� Map ���
		Map<Student.Sex, String> mapByName = totalList.stream()
				.collect(
					Collectors.groupingBy(
						Student :: getSex, 
						Collectors.mapping(
							Student :: getName,
							Collectors.joining(",")
						)
					)
				);
		System.out.println("���л� ��ü �̸�: " + mapByName.get(Student.Sex.MALE));
		System.out.println("���л� ��ü �̸�: " + mapByName.get(Student.Sex.FEMALE));
	}
}
