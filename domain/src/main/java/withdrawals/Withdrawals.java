package withdrawals;

import operations.Operation;
import operations.OperationType;
import operations.OperationsAPI;

public class Withdrawals implements WithdrawalsAPI {
    private final OperationsAPI operationsAPI;

    public Withdrawals(OperationsAPI operationsAPI) {
        this.operationsAPI = operationsAPI;
    }

    @Override
    public void makeWithdrawal(WithdrawalCommand command) {
        Operation operation = new Operation(command.getAmount(), OperationType.WITHDRAWAL);
        operationsAPI.saveOperationForAccount(operation, command.getAccountId());
    }
}
