package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Money money = InputUtils.inputMoney();
            LottoCount totalLottoCount = money.numberOfLottoCanBuy(LottoMachine.LOTTO_PRICE);
            LottoCount manualLottoCount = InputUtils.inputManualLottoCount(totalLottoCount);
            RandomNumbers randomNumbers = new RandomNumbers();
            LottoMachine lottoMachine = new LottoMachine(money, randomNumbers, manualLottoCount);
            Lottos manualLottos = InputUtils.inputManualLottos(manualLottoCount);
            lottoMachine.addManualLottos(manualLottos);
            Lottos lottos = lottoMachine.purchaseAutoLottos();
            OutputUtils.printLottoCount(manualLottoCount, lottoMachine.getAutoLottoCount());
            OutputUtils.printLottoNumbers(lottos);
            Lotto winningLotto = InputUtils.inputWinningNumbers();
            LottoNumber bonusLottoNumber = InputUtils.inputBonusNumber(winningLotto);
            LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusLottoNumber);
            OutputUtils.printLottosResult(lottoResult);
            OutputUtils.printReturnOnLotto(lottoResult.rateOfReturn());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
