package chapter12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // BASIC_ISO_DATE 포맷 사용
        DateTimeFormatter basicIsoFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        String basicIsoFormattedDate = today.format(basicIsoFormatter);
        System.out.println("BASIC_ISO_DATE 형식으로 포맷팅: " + basicIsoFormattedDate);

        try {
            LocalDate parsedBasicIsoDate = LocalDate.parse(basicIsoFormattedDate, basicIsoFormatter);
            System.out.println("BASIC_ISO_DATE 형식으로 파싱된 날짜: " + parsedBasicIsoDate);
        } catch (DateTimeParseException e) {
            System.err.println("BASIC_ISO_DATE 형식으로 파싱 중 오류: " + e.getMessage());
        }

        // ISO_LOCAL_DATE 포맷 사용
        DateTimeFormatter isoLocalDateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String isoLocalDateFormattedDate = today.format(isoLocalDateFormatter);
        System.out.println("ISO_LOCAL_DATE 형식으로 포맷팅: " + isoLocalDateFormattedDate);

        try {
            LocalDate parsedIsoLocalDate = LocalDate.parse(isoLocalDateFormattedDate, isoLocalDateFormatter);
            System.out.println("ISO_LOCAL_DATE 형식으로 파싱된 날짜: " + parsedIsoLocalDate);
        } catch (DateTimeParseException e) {
            System.err.println("ISO_LOCAL_DATE 형식으로 파싱 중 오류: " + e.getMessage());
        }
    }
}
