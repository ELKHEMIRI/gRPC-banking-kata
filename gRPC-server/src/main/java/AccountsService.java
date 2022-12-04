import accounts.AccountId;
import accounts.AccountsAPI;
import io.grpc.stub.StreamObserver;

public class AccountsService extends accountsGrpc.accountsImplBase {
    private final AccountsAPI accountsAPI;

    public AccountsService(AccountsAPI accountsAPI) {
        this.accountsAPI = accountsAPI;
    }

    @Override
    public void create(Empty request, StreamObserver<AccountCreationResponse> responseObserver) {
        AccountId accountId = accountsAPI.createAccount();
        responseObserver.onNext(AccountCreationResponse.newBuilder()
                .setAccountId(accountId.toString())
                        .setResponseCode(200)
                        .setResponseMessage("Account created with success")
                .build());
        responseObserver.onCompleted();
    }
}
