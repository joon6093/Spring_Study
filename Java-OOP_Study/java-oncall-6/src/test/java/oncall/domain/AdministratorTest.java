package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import oncall.error.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AdministratorTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        void 올바르게_생성된다() {
            // given
            WeekdayList weekdayList = new WeekdayList(
                    List.of(new Worker("1"), new Worker("2"), new Worker("3"), new Worker("4"), new Worker("5")));
            WeekendList weekendList = new WeekendList(
                    List.of(new Worker("1"), new Worker("2"), new Worker("3"), new Worker("4"), new Worker("5")));

            Administrator administrator = new Administrator(weekdayList, weekendList);

            // then
            assertThat(administrator.findNextDayWorker(new MonthAndDay(Month.APRIL, Day.FRIDAY),
                    new Worker("1")).getWorker()).isEqualTo(new Worker("2"));

            assertSoftly(softly -> {
                softly.assertThat(null).hasSize(3);
                softly.assertThat(null).isEqualTo("<예상 값>");
            });
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class 유효하지않은경우 {

        @Test
        void 입력값이Null일때() {
            // when & then
            assertThatThrownBy(() -> new Worker("ㅎㅇㅎㅎㅎㅇㅎㅇ"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorType.INVALID_INPUT.getMessage());
        }
    }
}
