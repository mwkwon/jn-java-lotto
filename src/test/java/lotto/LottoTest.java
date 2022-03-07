package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTest {
    @Test
    void 로또_생성_테스트() {
        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList())));
    }

    static Stream<Arguments> 로또_당첨_번호() {
        return Stream.of(
                Arguments.of(
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                        6),
                Arguments.of(
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{11, 12, 13, 14, 15, 16}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                        0
                ),
                Arguments.of(
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                        new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 13, 14, 15, 16}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                        2
                )
        );
    }

    @ParameterizedTest
    @MethodSource("로또_당첨_번호")
    void 로또_맞춘_개수(Lotto lotto, Lotto winningLotto, int matchCount) {
        assertEquals(lotto.matchCount(winningLotto), matchCount);
    }

    static Stream<Arguments> 로또_보너스_번호() {
        return Stream.of(
            Arguments.of(
                new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                LottoNumber.of(1),
                true),
            Arguments.of(
                new Lotto(new LottoNumbers(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList()))),
                LottoNumber.of(10),
                false
            )
        );
    }

    @ParameterizedTest
    @MethodSource("로또_보너스_번호")
    void 로또_보너스_번호_맞췄는지_여부(Lotto lotto, LottoNumber bonusNumber, boolean isMatchBonus) {
        assertEquals(lotto.isMatchBonus(bonusNumber), isMatchBonus);
    }
}
