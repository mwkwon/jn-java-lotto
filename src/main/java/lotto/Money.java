package lotto;

public class Money {

    private static final String MONEY_NEGATIVE_ERROR = "돈은 음수이거나 0일 수 없습니다.";
    private static final String MONEY_DIVIDE_ERROR = "돈은 1000원 단위만 가능합니다.";
    private static final int COST = 1000;
    private static final int ZERO = 0;

    public final int money;

    public Money(int money) {
        validMoney(money);
        this.money = money;
    }

    public int calculate() {
        return this.money / COST;
    }

    public int getMoney() {
        return this.money;
    }

    private void validMoney(int money) {
        if (money <= ZERO) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR);
        } else if (money % COST != ZERO) {
            throw new IllegalArgumentException(MONEY_DIVIDE_ERROR);
        }
    }
}
