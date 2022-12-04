package balances;

import accounts.AccountId;
import amount.Amount;

public interface BalancesAPI {
    Amount balanceOf(AccountId accountId);
}
