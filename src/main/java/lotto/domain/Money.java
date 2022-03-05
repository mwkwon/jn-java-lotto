package lotto.domain;

public class Money {

    private static final String MONEY_NEGATIVE_ERROR = "돈은 음수이거나 0일 수 없습니다.";
    private static final String MONEY_MINIMUM_ERROR = "돈은 1000원 보다 작을 수 없습니다.";
    private static final int COST = 1000;
    private static final int ZERO = 0;

    private final int price;

    public Money(int price) {
        validNegativeMoney(price);
        validMinimumMoney(price);
        this.price = moneyDivide(price);
    }

    public int lottoQuantity() {
        return this.price / COST;
    }

    public int getPrice() {
        return this.price;
    }

    private int moneyDivide(int price) {
        return price - price % COST;
    }

    private void validNegativeMoney(int price) {
        if (price <= ZERO) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR);
        }
    }

    private void validMinimumMoney(int price) {
        if (price < COST) {
            throw new IllegalArgumentException(MONEY_MINIMUM_ERROR);
        }
    }
}
