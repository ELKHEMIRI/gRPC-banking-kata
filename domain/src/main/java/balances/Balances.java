package balances;

import accounts.AccountId;
import amount.Amount;
import operations.OperationsAPI;

public class Balances implements BalancesAPI {
    private final OperationsAPI operationsAPI;

    public Balances(OperationsAPI operationsAPI) {
        this.operationsAPI = operationsAPI;
    }

    @Override
    public Amount balanceOf(AccountId accountId) {
        OperationAccumulator operationAccumulator = new OperationAccumulator();
        operationsAPI.getOperationsBy(accountId).forEach(operationAccumulator::accumulate);
        return operationAccumulator.getAmount();
    }
}
