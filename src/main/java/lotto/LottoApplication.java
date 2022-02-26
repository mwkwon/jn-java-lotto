package lotto;

import lotto.domain.*;
import lotto.utils.InputUtils;
import lotto.utils.OutputUtils;

import java.util.*;

public class LottoApplication {

    public static final String COMMA = ",";

    public static void main(String[] args) {

        Money money = new Money(InputUtils.lottoStartInput());

        // 로또 횟수
        int count = money.calculate();
        OutputUtils.lottoCountOutput(count);

        // 1 ~ 45 로또 총 번호
        TotalLottoNumbers totalLottoNumbers = new TotalLottoNumbers();

        Lottos lottos = new Lottos();

        // lottos 생성
        OutputUtils.lottosOutput(lottos.createLottos(count, totalLottoNumbers));

        String winningString = InputUtils.lottoWinningNumberInput();

        String[] winningStrings = winningString.split(COMMA);

        WinningNumbers winningNumbers = new WinningNumbers(winningStrings);

        // 당첨 로또 번호 생성
        Lotto winningLotto = new Lotto(winningNumbers.changeWinningLotto());

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        // 로또 당첨 체크
        lottoResult.winningLottosCheck();

        Map<Integer, Integer> winningResult = lottoResult.getWinningResult();

        // 당첨 결과 출력
        OutputUtils.prizeOutput(winningResult);
        OutputUtils.profitOutput(lottoResult.winningProfit(money.getMoney()));
    }
}
