package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private static final String WINNING_SIZE_ERROR = "로또 번호는 6개여야 합니다.";
    private static final String WINNING_BOUND_ERROR = "로또 번호는 1 ~ 45 사이에 숫자만 가능합니다.";
    private static final String REGEX = "[^0-9]";
    private static final String BLANK = "";
    private static final String COMMA = ",";
    private static final int SIZE = 6;
    private static final int START_BOUND = 1;
    private static final int END_BOUND = 45;
    private final String[] inputNumbers;

    public WinningNumbers(String inputNumber) {
        this.inputNumbers = validSizeCheck(splitInputNumber(inputNumber));
    }

    public Lotto changeWinningLotto() {
        List<LottoNumber> winningLotto = new ArrayList<>();
        for (String numberString : inputNumbers) {
            winningLotto.add(new LottoNumber(WinningNumberChange(numberString)));
        }
        return new Lotto(winningLotto);
    }

    private String[] splitInputNumber(String inputNumber) {
        return inputNumber.split(COMMA);
    }

    private Integer WinningNumberChange(String numberString) {
        return validBoundCheck(Integer.valueOf(numberString.replaceAll(REGEX, BLANK)));
    }

    private Integer validBoundCheck(Integer inputNumber) {
        if (inputNumber < START_BOUND || inputNumber > END_BOUND) {
            throw new IllegalArgumentException(WINNING_BOUND_ERROR);
        }
        return inputNumber;
    }

    private String[] validSizeCheck(String[] inputNumbers) {
        if (inputNumbers.length != SIZE) {
            throw new IllegalArgumentException(WINNING_SIZE_ERROR);
        }
        return inputNumbers;
    }
}
