import accounts.AccountId;
import accounts.Accounts;
import accounts.AccountsSPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountsTest {

    private Accounts accounts;
    private AccountsSPI accountsSPI;
    private final ArgumentCaptor<AccountId> accountIdArgumentCaptor = ArgumentCaptor.forClass(AccountId.class);;

    @BeforeEach
    void setUp() {
        accountsSPI = mock(AccountsSPI.class);
        accounts = new Accounts(accountsSPI);
    }

    @Test
    void shouldCreateANewAccount() {
        AccountId accountId = accounts.createAccount();

        verify(accountsSPI).createAccount(accountIdArgumentCaptor.capture());
        assertThat(accountId).isEqualTo(accountIdArgumentCaptor.getValue());
    }
}
