package pra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PraLocalDateTime {
    public static void main(String[] args) {

        //현재 날짜와 시간
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS")));

        int year=2024;
        int month = 2;
        int day = 29;
        LocalDateTime paramDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);

        System.out.println("paramDateTime = " + paramDateTime);
        String formatParamDate = paramDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("formatParamDate = " + formatParamDate);


    }
}
