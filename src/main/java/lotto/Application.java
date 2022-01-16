package lotto;

import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        try {
            Money money = new Money(InputUtils.inputMoney());
            LottoMachine lottoMachine = new LottoMachine(money);
            Lottos lottos = lottoMachine.purchaseLottos();
            OutputUtils.printLottoCount(money.numberOfLottoCanBuy(LottoMachine.LOTTO_PRICE));
            OutputUtils.printLottoNumbers(lottos);
            LottoNumbers winningNumbers = new LottoNumbers(InputUtils.inputWinningNumbers());
            LinkedHashMap<LottoPrize, Integer> result = lottoMachine.lottosResult(winningNumbers);
            OutputUtils.printLottosResult(result);
            OutputUtils.printReturnOnLotto(Calculator.returnOnLotto(result));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
