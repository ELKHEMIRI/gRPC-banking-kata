import accounts.AccountId;
import amount.Amount;
import operations.Operation;
import operations.OperationsAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import withdrawals.WithdrawalCommand;
import withdrawals.Withdrawals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WithdrawalsTest {
    private Withdrawals withdrawals;
    private OperationsAPI operationsAPI;
    private AccountId accountId;
    private ArgumentCaptor<Operation> operationArgumentCaptor;
    private ArgumentCaptor<AccountId> accountIdArgumentCaptor;

    @BeforeEach
    void setUp() {
        operationsAPI = mock(OperationsAPI.class);
        withdrawals = new Withdrawals(operationsAPI);
        accountId = AccountId.generate();
        operationArgumentCaptor = ArgumentCaptor.forClass(Operation.class);
        accountIdArgumentCaptor = ArgumentCaptor.forClass(AccountId.class);
    }

    @Test
    void shouldMakeADeposit() {
        Amount amount = Amount.inEuros(2000);
        var command = new WithdrawalCommand(accountId, amount);

        withdrawals.makeWithdrawal(command);

        verify(operationsAPI).saveOperationForAccount(operationArgumentCaptor.capture(), accountIdArgumentCaptor.capture());
        Operation withdrawOperation = operationArgumentCaptor.getValue();
        assertThat(withdrawOperation.isDeposit()).isFalse();
        assertThat(withdrawOperation.getAmount()).isEqualTo(amount);
        assertThat(accountIdArgumentCaptor.getValue()).isEqualTo(accountId);
    }
}
