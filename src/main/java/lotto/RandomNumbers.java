package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 45;
    private final int ZERO = 0;
    private final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> randomNumbers;

    public RandomNumbers() {
        int[] range = IntStream.rangeClosed(MIN_NUM, MAX_NUM).toArray();
        randomNumbers = Arrays.stream(range).boxed().collect(Collectors.toList());
    }

    public List<Integer> lottoNumbers() {
        Collections.shuffle(randomNumbers);
        List<Integer> lottoNumbers = randomNumbers.subList(ZERO, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
