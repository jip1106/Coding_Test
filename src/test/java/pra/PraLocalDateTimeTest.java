package pra;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
class PraLocalDateTimeTest {


    @Test
    public void localDateTimeJava8() throws Exception {
        //현재 날짜
        LocalDateTime currentDateTime = LocalDateTime.now();
        log.info("현재날짜 : {} " , currentDateTime);

        //Date포맷
        String formatDate = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        log.info("yyyy-MM-dd 포맷 : {} " , formatDate);
        log.info("년 {} " ,currentDateTime.getYear());
        log.info("월 {} " ,currentDateTime.getMonthValue());
        log.info("일 {} " ,currentDateTime.getDayOfMonth());
        log.info("현재 요일 {} " ,currentDateTime.getDayOfWeek());
        log.info("현재 시 {} " ,currentDateTime.getHour());
        log.info("현재 분 {} " ,currentDateTime.getMinute());
        log.info("현재 초 {} " ,currentDateTime.getSecond());
        log.info("현재 나노 {} " ,currentDateTime.getNano());

        //파라미터
        LocalDateTime localDateTime = LocalDateTime.of(2023, 12, 1, 0, 0, 0);
        log.info("LocalDateTime.of {} " , localDateTime);

        LocalDate localDate = LocalDate.of(2023, 12, 1);
        log.info("LocalDate.of {} " , localDate);

        Assertions.assertThat(localDate.isLeapYear()).isFalse();
        Assertions.assertThat(LocalDate.now().isLeapYear()).isTrue();

    }

}