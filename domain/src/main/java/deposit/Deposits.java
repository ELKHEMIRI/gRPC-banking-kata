package deposit;

import operations.Operation;
import operations.OperationType;
import operations.OperationsAPI;

public class Deposits implements DepositsAPI {
    private final OperationsAPI operationsAPI;

    public Deposits(OperationsAPI operationsAPI) {
        this.operationsAPI = operationsAPI;
    }

    @Override
    public void makeDeposit(DepositCommand command) {
        Operation operation = new Operation(command.getAmount(), OperationType.DEPOSIT);
        operationsAPI.saveOperationForAccount(operation, command.getAccountId());
    }
}
