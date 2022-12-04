import accounts.AccountId;
import amount.Amount;
import balances.BalancesAPI;
import io.grpc.stub.StreamObserver;

public class BalancesService extends balancesGrpc.balancesImplBase {
    private final BalancesAPI balancesAPI;

    public BalancesService(BalancesAPI balancesAPI) {
        this.balancesAPI = balancesAPI;
    }

    @Override
    public void balance(BalanceRequest request, StreamObserver<BalanceResponse> responseObserver) {
        String accountId = request.getAccountId();
        Amount amount = balancesAPI.balanceOf(AccountId.from(accountId));
        responseObserver.onNext(BalanceResponse.newBuilder()
                .setAmountInCents(amount.inCents())
                .setResponseCode(200)
                .setResponseMessage("Balance returned with success")
                .build());
        responseObserver.onCompleted();
    }
}
