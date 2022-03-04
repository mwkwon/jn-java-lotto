package lotto;

import lotto.domain.*;
import lotto.utils.InputUtils;
import lotto.utils.OutputUtils;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = new Money(InputUtils.lottoStartInput());

        // 로또 횟수
        int count = money.calculate();
        OutputUtils.lottoCountOutput(count);

        // 1 ~ 45 로또 총 번호
        TotalLottoNumbers totalLottoNumbers = new TotalLottoNumbers();
        Lottos lottos = new Lottos();
        lottos.createLottos(count, totalLottoNumbers);

        // lottos 생성
        OutputUtils.lottosOutput(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(InputUtils.lottoWinningNumberInput());

        // 당첨 로또 번호 생성
        Lotto winningLotto = winningNumbers.changeWinningLotto();
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        // 로또 당첨 체크
        lottoResult.winningLottosCheck();

        // 당첨 결과 출력
        OutputUtils.prizeOutput(lottoResult.getWinningResult());
        OutputUtils.profitOutput(lottoResult.winningProfit(money.getPrice()));
    }
}
