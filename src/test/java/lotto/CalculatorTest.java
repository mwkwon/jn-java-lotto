package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class CalculatorTest {

    static Stream<Arguments> 로또_수익률() {
        return Stream.of(
                Arguments.of(new LinkedHashMap<LottoPrize, Integer>() {
                    {
                        put(LottoPrize.NOTHING, 10);
                        put(LottoPrize.FOURTH_PRIZE, 0);
                        put(LottoPrize.THIRD_PRIZE, 0);
                        put(LottoPrize.SECOND_PRIZE, 0);
                        put(LottoPrize.FIRST_PRIZE, 0);
                    }
                }, 0.0f),
                Arguments.of(new LinkedHashMap<LottoPrize, Integer>() {
                    {
                        put(LottoPrize.NOTHING, 9);
                        put(LottoPrize.FOURTH_PRIZE, 1);
                        put(LottoPrize.THIRD_PRIZE, 0);
                        put(LottoPrize.SECOND_PRIZE, 0);
                        put(LottoPrize.FIRST_PRIZE, 0);
                    }
                }, 0.5f),
                Arguments.of(new LinkedHashMap<LottoPrize, Integer>() {
                    {
                        put(LottoPrize.NOTHING, 10);
                        put(LottoPrize.FOURTH_PRIZE, 1);
                        put(LottoPrize.THIRD_PRIZE, 2);
                        put(LottoPrize.SECOND_PRIZE, 0);
                        put(LottoPrize.FIRST_PRIZE, 0);
                    }
                }, 8.076923f)
        );
    }

    @ParameterizedTest
    @MethodSource("로또_수익률")
    void 로또_수익률_계산기(LinkedHashMap<LottoPrize, Integer> result, float returnOnLotto) {
        assertEquals(Calculator.returnOnLotto(result), returnOnLotto);
    }
}
