package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import oncall.error.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WorkerTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        void 올바르게_생성된다() {
            // given
            Worker worker = new Worker("송제용");

            // then
            assertSoftly(softly -> {
                softly.assertThat(worker.getName()).isEqualTo("송제용");
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
