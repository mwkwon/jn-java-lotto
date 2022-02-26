package lotto.domain;

public enum LottoPrize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    public final int count;
    public final int prize;

    LottoPrize(int count, int money) {
        this.count = count;
        this.prize = money;
    }
}
