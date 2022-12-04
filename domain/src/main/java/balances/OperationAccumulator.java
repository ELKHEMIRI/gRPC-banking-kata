package balances;

import amount.Amount;
import operations.Operation;

public class OperationAccumulator {
    private Amount amount = Amount.ZERO;

    public void accumulate(Operation operation) {
        Amount anotherAmount = operation.getAmount();
        amount = operation.isDeposit() ? amount.plus(anotherAmount) : amount.minus(anotherAmount);
    }

    public Amount getAmount() {
        return amount;
    }
}
