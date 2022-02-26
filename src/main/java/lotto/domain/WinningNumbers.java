package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final String SPACE = " ";
    private static final String BLANK = "";
    private final String[] winningStrings;

    public WinningNumbers(String[] winningStrings) {
        this.winningStrings = winningStrings;
    }

    public LottoNumbers changeWinningLotto() {
        List<Integer> winningLotto = new ArrayList<>();
        for (String string : winningStrings) {
            winningLotto.add(Integer.valueOf(string.replace(SPACE, BLANK)));
        }
        return new LottoNumbers(winningLotto);
    }
}
