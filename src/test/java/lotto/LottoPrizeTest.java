package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class LottoPrizeTest {

    static Stream<Arguments> 로또_맞춘_개수_및_상금() {
        return Stream.of(
                Arguments.of(0, LottoPrize.NOTHING),
                Arguments.of(1, LottoPrize.NOTHING),
                Arguments.of(2, LottoPrize.NOTHING),
                Arguments.of(3, LottoPrize.FOURTH_PRIZE),
                Arguments.of(4, LottoPrize.THIRD_PRIZE),
                Arguments.of(5, LottoPrize.SECOND_PRIZE),
                Arguments.of(6, LottoPrize.FIRST_PRIZE)
        );
    }

    @ParameterizedTest
    @MethodSource("로또_맞춘_개수_및_상금")
    void 로또_맞춘_개수에_따른_상금_반환_확인(int matchCount, LottoPrize lottoPrize) {
        assertEquals(LottoPrize.findLottoPrize(matchCount), lottoPrize);
    }
}
