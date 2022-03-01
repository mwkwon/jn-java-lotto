package lotto.domain;

public class Money {

    private static final String MONEY_NEGATIVE_ERROR = "돈은 음수이거나 0일 수 없습니다.";
    private static final String MONEY_DIVIDE_ERROR = "돈은 1000원 단위만 가능합니다.";
    private static final int COST = 1000;
    private static final int ZERO = 0;

    private final int price;

    public Money(int money) {
        validNegativeMoney(money);
        validDivideMoney(money);
        this.price = money;
    }

    public int calculate() {
        return this.price / COST;
    }

    public int getPrice() {
        return this.price;
    }

    private void validNegativeMoney(int money) {
        if (money <= ZERO) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR);
        }
    }

    private void validDivideMoney(int money) {
        if (money % COST != ZERO) {
            throw new IllegalArgumentException(MONEY_DIVIDE_ERROR);
        }
    }
}
