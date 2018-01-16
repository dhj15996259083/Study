package fangdai;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    private final static BigDecimal rate = new BigDecimal(0.048);
    private final static BigDecimal rate_all = new BigDecimal(rate.add(new BigDecimal(1)).floatValue());
    private final static BigDecimal income = new BigDecimal(16);

    public static void main(String[] args) {
        Main t = new Main();
        System.out.println(t.getTotal(20));
    }


    // [(1 + rate) ˆ year - 1] * income / rate
    public BigDecimal getTotal(int year) {
        return income.multiply(rate_all.pow(year).subtract(new BigDecimal(1)))
                .divide(rate, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal get(float total, int times) {
        if (times == 1) {
            return total(total);
        } else {
            return total(get(total, times - 1).floatValue());
        }
    }

    private BigDecimal total(float total) {
        return new BigDecimal(total).multiply(rate.add(new BigDecimal(1)));
    }
}
