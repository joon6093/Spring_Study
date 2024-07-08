package chapter1.ExecuteAroundPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class ExecuteAroundPattern {
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new StringReader("This is a test line.\nThis is the second line."))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        // 한 줄 읽기
        String oneLine = processFile(br -> br.readLine());
        System.out.println(oneLine);

        // 두 줄 읽기
        String twoLines = processFile(br -> br.readLine() + "\n" + br.readLine());
        System.out.println(twoLines);
    }
}
