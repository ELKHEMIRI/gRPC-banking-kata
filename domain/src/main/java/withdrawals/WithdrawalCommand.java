package withdrawals;

import accounts.AccountId;
import amount.Amount;

public class WithdrawalCommand {
    private final AccountId accountId;
    private final Amount amount;

    public WithdrawalCommand(AccountId accountId, Amount amount) {
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
