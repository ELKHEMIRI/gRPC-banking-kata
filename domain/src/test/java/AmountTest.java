import amount.Amount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    private Amount amount;
    private Amount anotherAmount;

    @Test
    void shouldBeEquals() {
        amount = Amount.inCents(100);
        anotherAmount = Amount.inCents(100);

        assertThat(amount).isEqualTo(anotherAmount);
    }

    @Test
    void shouldNotBeEquals() {
        amount = Amount.inCents(100);
        anotherAmount = Amount.inCents(120);

        assertThat(amount).isNotEqualTo(anotherAmount);
    }

    @Test
    void shouldBeEqualsCentsAndEuros() {
        amount = Amount.inCents(1025);
        anotherAmount = Amount.inEuros(10.25);

        assertThat(amount).isEqualTo(anotherAmount);
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNotValid() {
        assertThatThrownBy(() -> Amount.inEuros(10.523))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void shouldAddAmounts() {
        Amount sum = Amount.inEuros(2500.00)
                .plus(Amount.inCents(25000))
                .plus(Amount.inEuros(250.0));

        assertThat(sum).isEqualTo(Amount.inEuros(3000.00));
    }

    @Test
    void shouldSubstructAmounts() {
        Amount sum = Amount.inEuros(2500.00)
                .minus(Amount.inEuros(500));

        assertThat(sum).isEqualTo(Amount.inEuros(2000));
    }
}
