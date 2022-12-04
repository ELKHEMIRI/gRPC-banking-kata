package operations;

import amount.Amount;

public class Operation {
    private final Amount amount;
    private final OperationType type;

    public Operation(Amount amount, OperationType type) {
        this.amount = amount;
        this.type = type;
    }

    public Amount getAmount() {
        return amount;
    }

    public OperationType getType() {
        return type;
    }

    public boolean isDeposit() {
        return type == OperationType.DEPOSIT;
    }
}
