package accounts;

import java.util.HashSet;
import java.util.Set;

public class InMemoryAccountsAdapter implements AccountsSPI {
    private Set<AccountId> accountIds = new HashSet<>();
    @Override
    public void createAccount(AccountId accountId) {
        accountIds.add(accountId);
    }
}
