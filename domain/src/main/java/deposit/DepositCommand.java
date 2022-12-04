package deposit;

import accounts.AccountId;
import amount.Amount;

public class DepositCommand {
    private final AccountId accountId;
    private final Amount amount;

    public DepositCommand(AccountId accountId, Amount amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Amount getAmount() {
        return amount;
    }
}
