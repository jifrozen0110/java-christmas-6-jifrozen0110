package christmas.common.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static final String KRW = "원";

    public static String fromToKRW(int amount) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(amount) + KRW;
    }
}
