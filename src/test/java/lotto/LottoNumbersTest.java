package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class LottoNumbersTest {

    static Stream<Arguments> 에러_로또_번호_리스트() {
        return Stream.of(
                Arguments.of(Arrays.stream(new int[]{1, 2, 3, 4, 5}).boxed().map(LottoNumber::of).collect(Collectors.toList())),
                Arguments.of(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7}).boxed().map(LottoNumber::of).collect(Collectors.toList()))
        );
    }

    static Stream<Arguments> 에러_로또_번호_세트() {
        return Stream.of(
                Arguments.of(Arrays.stream(new int[]{1, 2, 3, 4, 5}).boxed().map(LottoNumber::of).collect(Collectors.toSet())),
                Arguments.of(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7}).boxed().map(LottoNumber::of).collect(Collectors.toSet()))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("에러_로또_번호_리스트")
    void 로또_번호_개수_유효성_검사_리스트(List<LottoNumber> lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @ParameterizedTest
    @NullSource
    @MethodSource("에러_로또_번호_세트")
    void 로또_번호_개수_유효성_검사_세트(Set<LottoNumber> lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    static Stream<Arguments> 정상_로또_번호_리스트() {
        return Stream.of(
                Arguments.of(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toList())),
                Arguments.of(Arrays.stream(new int[]{11, 22, 33, 40, 41, 45}).boxed().map(LottoNumber::of).collect(Collectors.toList()))
        );
    }

    static Stream<Arguments> 정상_로또_번호_세트() {
        return Stream.of(
                Arguments.of(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().map(LottoNumber::of).collect(Collectors.toSet())),
                Arguments.of(Arrays.stream(new int[]{11, 22, 33, 40, 41, 45}).boxed().map(LottoNumber::of).collect(Collectors.toSet()))
        );
    }

    @ParameterizedTest
    @MethodSource("정상_로또_번호_리스트")
    void 로또_번호_정상_생성_리스트(List<LottoNumber> lottoNumbers) {
        assertThat(new LottoNumbers(lottoNumbers)).isEqualTo(new LottoNumbers(lottoNumbers));
    }

    @ParameterizedTest
    @MethodSource("정상_로또_번호_세트")
    void 로또_번호_정상_생성_세트(Set<LottoNumber> lottoNumbers) {
        assertThat(new LottoNumbers(lottoNumbers)).isEqualTo(new LottoNumbers(lottoNumbers));
    }
}
