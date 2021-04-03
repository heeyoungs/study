package ch16.page2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileContentExample {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:\\Users\\user\\Desktop\\study\\text.txt");
		Stream<String> stream;

		stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach( System.out :: println ); // 메소드 참조로 파일 내용 출력
		stream.close();
		System.out.println();

		File file = path.toFile(); // 18장 파일 입출력
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		stream = br.lines();
		stream.forEach( System.out :: println );
		stream.close();
	}
}
