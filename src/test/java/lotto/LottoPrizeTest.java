package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoPrizeTest {

    static Stream<Arguments> 로또_맞춘_개수_및_상금() {
        return Stream.of(
                Arguments.of(0, false, LottoPrize.NOTHING),
                Arguments.of(1, false, LottoPrize.NOTHING),
                Arguments.of(2, false, LottoPrize.NOTHING),
                Arguments.of(3, false, LottoPrize.FIFTH_PRIZE),
                Arguments.of(4, false, LottoPrize.FOURTH_PRIZE),
                Arguments.of(5, false, LottoPrize.THIRD_PRIZE),
                Arguments.of(5, true, LottoPrize.SECOND_PRIZE),
                Arguments.of(6, false, LottoPrize.FIRST_PRIZE)
        );
    }

    @ParameterizedTest
    @MethodSource("로또_맞춘_개수_및_상금")
    void 로또_맞춘_개수에_따른_상금_반환_확인(int matchCount, boolean isMatchBonus, LottoPrize lottoPrize) {
        assertThat(LottoPrize.findLottoPrize(matchCount, isMatchBonus)).isEqualTo(lottoPrize);
    }
}
