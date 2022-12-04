package accounts;

public class Accounts implements AccountsAPI {
    private final AccountsSPI accountsSPI;

    public Accounts(AccountsSPI accountsSPI) {
        this.accountsSPI = accountsSPI;
    }

    @Override
    public AccountId createAccount() {
        AccountId generatedAccountId = AccountId.generate();
        accountsSPI.createAccount(generatedAccountId);
        return generatedAccountId;
    }
}
