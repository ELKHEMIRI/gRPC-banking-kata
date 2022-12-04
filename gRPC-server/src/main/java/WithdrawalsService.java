import accounts.AccountId;
import amount.Amount;
import io.grpc.stub.StreamObserver;
import withdrawals.WithdrawalCommand;
import withdrawals.WithdrawalsAPI;

public class WithdrawalsService extends withdrawalsGrpc.withdrawalsImplBase {
    private final WithdrawalsAPI withdrawalsAPI;

    public WithdrawalsService(WithdrawalsAPI withdrawalsAPI) {
        this.withdrawalsAPI = withdrawalsAPI;
    }

    @Override
    public void makeWithdraw(WithdrawRequest request, StreamObserver<WithdrawResponse> responseObserver) {
        String accountId = request.getAccountId();
        int amountInCents = request.getAmountInCents();
        WithdrawalCommand command = new WithdrawalCommand(AccountId.from(accountId), Amount.inCents(amountInCents));
        withdrawalsAPI.makeWithdrawal(command);
        responseObserver.onNext(WithdrawResponse.newBuilder()
                .setResponseCode(200)
                .setResponseMessage("Withdraw done with success")
                .build());
        responseObserver.onCompleted();
    }
}
