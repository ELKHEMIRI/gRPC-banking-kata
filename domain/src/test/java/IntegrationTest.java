import accounts.*;
import amount.Amount;
import balances.Balances;
import balances.BalancesAPI;
import deposit.DepositCommand;
import deposit.Deposits;
import deposit.DepositsAPI;
import operations.InMemoryOperationAdapter;
import operations.Operations;
import operations.OperationsAPI;
import operations.OperationsSPI;
import org.junit.jupiter.api.Test;
import withdrawals.WithdrawalCommand;
import withdrawals.Withdrawals;
import withdrawals.WithdrawalsAPI;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {
    AccountsSPI accountsSPI = new InMemoryAccountsAdapter();
    AccountsAPI accountsAPI = new Accounts(accountsSPI);
    OperationsSPI operationsSPI = new InMemoryOperationAdapter();
    OperationsAPI operationsAPI = new Operations(operationsSPI);
    BalancesAPI balancesAPI = new Balances(operationsAPI);
    DepositsAPI depositsAPI = new Deposits(operationsAPI);
    WithdrawalsAPI withdrawalsAPI = new Withdrawals(operationsAPI);

    @Test
    void should_deposit_and_withdraw_on_the_same_account() {
        AccountId accountId = accountsAPI.createAccount();
        assertThat(balancesAPI.balanceOf(accountId)).isEqualTo(Amount.ZERO);

        depositsAPI.makeDeposit(new DepositCommand(accountId, Amount.inEuros(2500)));
        depositsAPI.makeDeposit(new DepositCommand(accountId, Amount.inCents(10000)));
        withdrawalsAPI.makeWithdrawal(new WithdrawalCommand(accountId, Amount.inEuros(300)));

        assertThat(balancesAPI.balanceOf(accountId)).isEqualTo(Amount.inEuros(2300));
    }

    @Test
    void should_deposit_and_withdraw_on_the_different_accounts() {
        AccountId account1 = accountsAPI.createAccount();
        AccountId account2 = accountsAPI.createAccount();
        depositsAPI.makeDeposit(new DepositCommand(account1, Amount.inEuros(1200)));
        depositsAPI.makeDeposit(new DepositCommand(account1, Amount.inCents(10000)));
        withdrawalsAPI.makeWithdrawal(new WithdrawalCommand(account1, Amount.inEuros(100)));
        depositsAPI.makeDeposit(new DepositCommand(account2, Amount.inEuros(2500)));
        withdrawalsAPI.makeWithdrawal(new WithdrawalCommand(account2, Amount.inEuros(500)));
        withdrawalsAPI.makeWithdrawal(new WithdrawalCommand(account2, Amount.inEuros(200)));

        assertThat(balancesAPI.balanceOf(account1)).isEqualTo(Amount.inEuros(1200));
        assertThat(balancesAPI.balanceOf(account2)).isEqualTo(Amount.inEuros(1800));
    }
}
