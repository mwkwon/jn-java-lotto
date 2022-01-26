package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class RandomNumbersTest {

    @Test
    void 로또_번호_생성() {
        RandomNumbers randomNumbers = new RandomNumbers();
        List<LottoNumber> lottoNumbers = randomNumbers.lottoNumbers();
        assertEquals(lottoNumbers.size(), 6);
        System.out.println(lottoNumbers);
    }
}
