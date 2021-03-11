package chap16.src.sec09.stream_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		/*//���� �߻�(java.util.NoSuchElementException)
		double avg = list.stream()
			.mapToInt(Integer :: intValue)
			.average()	
			.getAsDouble(); 
		*/
		
		//���1
		OptionalDouble optional = list.stream()
			.mapToInt(Integer :: intValue)
			.average();	
		if(optional.isPresent()) {
			System.out.println("���1_���: " + optional.getAsDouble());
		} else {
			System.out.println("���1_���: 0.0");
		}
		
		//���2
		double avg = list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.orElse(0.0);
		System.out.println("���2_���: " + avg);
		
		//���3
		list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.ifPresent(a -> System.out.println("���3_���: " + a));
	}
}
