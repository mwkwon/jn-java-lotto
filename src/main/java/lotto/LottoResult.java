package lotto;

public class LottoResult {

    private final Lottos lottos;
    private final Lotto winningLotto;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public void LottoContains() {
        for (int i = 0; i < lottos.getLottos().size(); i++) {
//            lottos.getLottos().get(i).getLotto().contains(winningLotto);
        }
    }


}
