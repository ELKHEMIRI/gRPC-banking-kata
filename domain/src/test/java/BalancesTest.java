import accounts.AccountId;
import amount.Amount;
import balances.Balances;
import operations.Operation;
import operations.OperationType;
import operations.OperationsAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BalancesTest {

    private Balances balances;
    private OperationsAPI operationsAPI;
    private AccountId accountId;

    @BeforeEach
    void setUp() {
        operationsAPI = mock(OperationsAPI.class);
        balances = new Balances(operationsAPI);
        accountId = AccountId.generate();
    }

    @Test
    void should_return_zero_when_there_is_no_operations_on_account() {
        when(operationsAPI.getOperationsBy(accountId)).thenReturn(Collections.emptyList());

        Amount amount = balances.balanceOf(accountId);

        assertThat(amount).isEqualTo(Amount.ZERO);
    }

    @Test
    void should_sum_all_deposit_operations() {
        var depositOperation1 = new Operation(Amount.inEuros(300), OperationType.DEPOSIT);
        var depositOperation2 = new Operation(Amount.inEuros(2200), OperationType.DEPOSIT);
        var depositOperation3 = new Operation(Amount.inEuros(2500), OperationType.DEPOSIT);
        when(operationsAPI.getOperationsBy(accountId)).thenReturn(List.of(depositOperation1, depositOperation2, depositOperation3));

        Amount amount = balances.balanceOf(accountId);

        assertThat(amount).isEqualTo(Amount.inEuros(5000));
    }

    @Test
    void should_substruct_withdrawal_operations() {
        var depositOperation1 = new Operation(Amount.inEuros(300), OperationType.DEPOSIT);
        var depositOperation2 = new Operation(Amount.inEuros(2200), OperationType.DEPOSIT);
        var withdrawalOperation3 = new Operation(Amount.inEuros(500), OperationType.WITHDRAWAL);
        when(operationsAPI.getOperationsBy(accountId)).thenReturn(List.of(depositOperation1, depositOperation2, withdrawalOperation3));

        Amount amount = balances.balanceOf(accountId);

        assertThat(amount).isEqualTo(Amount.inEuros(2000));
    }
}
