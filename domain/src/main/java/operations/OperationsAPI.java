package operations;

import accounts.AccountId;

import java.util.Collection;

public interface OperationsAPI {
    Collection<Operation> getOperationsBy(AccountId accountId);

    void saveOperationForAccount(Operation operation, AccountId accountId);
}
