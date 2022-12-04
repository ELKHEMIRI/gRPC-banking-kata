import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class GRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        accountsGrpc.accountsBlockingStub accountsStub = accountsGrpc.newBlockingStub(channel);
        depositsGrpc.depositsBlockingStub depositsStub = depositsGrpc.newBlockingStub(channel);
        withdrawalsGrpc.withdrawalsBlockingStub withdrawalsStub = withdrawalsGrpc.newBlockingStub(channel);
        balancesGrpc.balancesBlockingStub balancesStub = balancesGrpc.newBlockingStub(channel);
        operationsGrpc.operationsBlockingStub operationsStub = operationsGrpc.newBlockingStub(channel);

        AccountCreationResponse accountCreationResponse = accountsStub
                .create(Empty.newBuilder().build());
        String accountId = accountCreationResponse.getAccountId();
        System.out.println(accountId);
        for (int i = 0; i < 100; i++) {
            depositsStub.makeDeposit(DepositRequest.newBuilder()
                    .setAccountId(accountId)
                    .setAmountInCents(10000)
                    .build());
        }

        for (int i = 0; i < 100; i++) {
            withdrawalsStub.makeWithdraw(WithdrawRequest.newBuilder()
                    .setAccountId(accountId)
                    .setAmountInCents(5000)
                    .build());
        }

        BalanceResponse balance = balancesStub.balance(BalanceRequest.newBuilder()
                .setAccountId(accountId)
                .build());
        System.out.println(balance.getAmountInCents());

        Iterator<OperationsResponse> operations = operationsStub.getOperations(OperationsRequest
                .newBuilder()
                .setAccountId(accountId)
                .build());

        while (operations.hasNext()) {
            OperationsResponse next = operations.next();
            System.out.println("next operations");
            System.out.println(next);
        }
    }
}
