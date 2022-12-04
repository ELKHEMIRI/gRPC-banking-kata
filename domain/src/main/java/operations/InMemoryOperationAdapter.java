package operations;

import accounts.AccountId;

import java.util.*;

public class InMemoryOperationAdapter implements OperationsSPI {
    private final Map<AccountId, List<Operation>> operations;

    public InMemoryOperationAdapter() {
        operations = new HashMap<>();
    }

    @Override
    public Collection<Operation> getOperationsBy(AccountId accountId) {
        return operations.getOrDefault(accountId, new ArrayList<>());
    }

    @Override
    public void saveOperationForAccount(Operation operation, AccountId accountId) {
        List<Operation> updatedOperations = operations.getOrDefault(accountId, new ArrayList<>());
        updatedOperations.add(operation);
        operations.put(accountId, updatedOperations);

    }
}
