import accounts.AccountId;
import amount.Amount;
import deposit.DepositCommand;
import deposit.DepositsAPI;
import io.grpc.stub.StreamObserver;

public class DepositsService extends depositsGrpc.depositsImplBase {
    private final DepositsAPI depositsAPI;

    public DepositsService(DepositsAPI depositsAPI) {
        this.depositsAPI = depositsAPI;
    }

    @Override
    public void makeDeposit(DepositRequest request, StreamObserver<DepositResponse> responseObserver) {
        String accountId = request.getAccountId();
        int amountInCents = request.getAmountInCents();
        DepositCommand command = new DepositCommand(AccountId.from(accountId), Amount.inCents(amountInCents));
        depositsAPI.makeDeposit(command);
        responseObserver.onNext(DepositResponse.newBuilder()
                .setResponseCode(200)
                .setResponseMessage("Deposit done with success")
                .build());
        responseObserver.onCompleted();
    }
}
