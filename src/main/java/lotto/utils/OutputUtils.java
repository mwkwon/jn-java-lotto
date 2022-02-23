package lotto.utils;

public class OutputUtils {

    private static final String LOTTO_COUNT_QUESTION = "개를 구매했습니다.";

    public static void lottoCountOutput(int count) {
        System.out.println(count + LOTTO_COUNT_QUESTION);
    }
}
