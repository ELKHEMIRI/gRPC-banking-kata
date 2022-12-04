import accounts.AccountId;
import amount.Amount;
import deposit.DepositCommand;
import deposit.Deposits;
import operations.Operation;
import operations.OperationsAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DepositsTest {
    private Deposits deposits;
    private OperationsAPI operationsAPI;
    private AccountId accountId;
    private ArgumentCaptor<Operation> operationArgumentCaptor;
    private ArgumentCaptor<AccountId> accountIdArgumentCaptor;

    @BeforeEach
    void setUp() {
        operationsAPI = mock(OperationsAPI.class);
        deposits = new Deposits(operationsAPI);
        accountId = AccountId.generate();
        operationArgumentCaptor = ArgumentCaptor.forClass(Operation.class);
        accountIdArgumentCaptor = ArgumentCaptor.forClass(AccountId.class);
    }

    @Test
    void shouldMakeADeposit() {
        Amount amount = Amount.inEuros(2000);
        var command = new DepositCommand(accountId, amount);

        deposits.makeDeposit(command);

        verify(operationsAPI).saveOperationForAccount(operationArgumentCaptor.capture(), accountIdArgumentCaptor.capture());
        Operation depositOperation = operationArgumentCaptor.getValue();
        assertThat(depositOperation.isDeposit()).isTrue();
        assertThat(depositOperation.getAmount()).isEqualTo(amount);
        assertThat(accountIdArgumentCaptor.getValue()).isEqualTo(accountId);
    }
}
