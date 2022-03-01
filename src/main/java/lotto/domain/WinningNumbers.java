package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final String WINNING_SIZE_ERROR = "로또 번호는 6개여야 합니다.";
    private static final int SIZE = 6;
    private static final String REGEX = "[^0-9]";
    private static final String BLANK = "";

    private final String[] inputNumbers;

    public WinningNumbers(String[] inputNumbers) {
        validSizeCheck(inputNumbers);
        this.inputNumbers = inputNumbers;
    }

    public Lotto changeWinningLotto() {
        List<Integer> winningLotto = new ArrayList<>();
        for (String string : inputNumbers) {
            winningLotto.add(Integer.valueOf(string.replaceAll(REGEX, BLANK)));
        }
        return new Lotto(winningLotto);
    }

    private void validSizeCheck(String[] inputNumbers) {
        if (inputNumbers.length != SIZE) {
            throw new IllegalArgumentException(WINNING_SIZE_ERROR);
        }
    }
}
