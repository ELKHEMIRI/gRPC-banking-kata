import accounts.AccountId;
import accounts.AccountsAPI;
import amount.Amount;
import balances.BalancesAPI;
import deposit.DepositCommand;
import deposit.DepositsAPI;
import io.grpc.stub.StreamObserver;
import operations.Operation;
import operations.OperationsAPI;
import withdrawals.WithdrawalCommand;
import withdrawals.WithdrawalsAPI;

import java.util.Collection;

import static java.lang.Thread.sleep;

public class AccountsService extends accountsGrpc.accountsImplBase {
    private final AccountsAPI accountsAPI;
    private final OperationsAPI operationsAPI;
    private final BalancesAPI balancesAPI;
    private final DepositsAPI depositsAPI;
    private final WithdrawalsAPI withdrawalsAPI;


    public AccountsService(AccountsAPI accountsAPI, OperationsAPI operationsAPI, BalancesAPI balancesAPI, DepositsAPI depositsAPI, WithdrawalsAPI withdrawalsAPI) {
        this.accountsAPI = accountsAPI;
        this.operationsAPI = operationsAPI;
        this.balancesAPI = balancesAPI;
        this.depositsAPI = depositsAPI;
        this.withdrawalsAPI = withdrawalsAPI;
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

    @Override
    public void getOperations(OperationsRequest request, StreamObserver<OperationsResponse> responseObserver) {
        String accountId = request.getAccountId();
        Collection<Operation> operations = operationsAPI.getOperationsBy(AccountId.from(accountId));
        operations.stream()
                .map(operation -> OperationsResponse.newBuilder()
                        .setAmountInCents(operation.getAmount().inCents())
                        .setType(operation.getType().toString())
                        .build())
                .forEach(response -> {
                    responseObserver.onNext(response);
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

//        for (Operation operation : operations) {
//            OperationsResponse response = OperationsResponse.newBuilder()
//                    .setAmountInCents(operation.getAmount().inCents())
//                    .setType(operation.getType().toString())
//                    .build();
//            responseObserver.onNext(response);
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        responseObserver.onCompleted();
    }
}
