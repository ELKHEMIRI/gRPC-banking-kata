package operations;

import accounts.AccountId;

import java.util.Collection;

public interface OperationsSPI {
    Collection<Operation> getOperationsBy(AccountId accountId);

    void saveOperationForAccount(Operation operation, AccountId accountId);
}
