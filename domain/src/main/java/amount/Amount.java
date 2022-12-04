package amount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Amount {
    public static final Amount ZERO = new Amount(0);
    private static final BigDecimal CENTS_PER_EURO = BigDecimal.valueOf(100);
    private final int valueInCents;

    public Amount(int valueInCents) {
        this.valueInCents = valueInCents;
    }

    public static Amount inCents(int value) {
        return new Amount(value);
    }

    public static Amount inEuros(double value) {
        return new Amount(BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.UNNECESSARY)
                .multiply(CENTS_PER_EURO)
                .intValue());
    }

    public int inCents() {
        return valueInCents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(valueInCents, amount.valueInCents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueInCents);
    }

    @Override
    public String toString() {
        return "amount.Amount{" +
                "valueInCents=" + valueInCents +
                '}';
    }

    public Amount plus(Amount anotherAmount) {
        return new Amount(valueInCents + anotherAmount.valueInCents);
    }

    public Amount minus(Amount anotherAmount) {
        return new Amount(valueInCents - anotherAmount.valueInCents);
    }
}
