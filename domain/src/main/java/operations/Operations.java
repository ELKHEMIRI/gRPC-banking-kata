package operations;

import accounts.AccountId;

import java.util.Collection;

public class Operations implements OperationsAPI {
    private final OperationsSPI operationsSPI;

    public Operations(OperationsSPI operationsSPI) {
        this.operationsSPI = operationsSPI;
    }

    @Override
    public Collection<Operation> getOperationsBy(AccountId accountId) {
        return operationsSPI.getOperationsBy(accountId);
    }

    @Override
    public void saveOperationForAccount(Operation operation, AccountId accountId) {
        operationsSPI.saveOperationForAccount(operation, accountId);
    }
}
