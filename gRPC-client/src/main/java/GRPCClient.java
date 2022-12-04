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

        AccountCreationResponse accountCreationResponse = accountsStub
                .create(Empty.newBuilder().build());
        String accountId = accountCreationResponse.getAccountId();
        System.out.println(accountId);
        for (int i = 0; i < 100; i++) {
            accountsStub.makeDeposit(DepositRequest.newBuilder()
                    .setAccountId(accountId)
                    .setAmountInCents(10000)
                    .build());
        }

        for (int i = 0; i < 100; i++) {
            accountsStub.makeWithdraw(WithdrawRequest.newBuilder()
                    .setAccountId(accountId)
                    .setAmountInCents(5000)
                    .build());
        }

        BalanceResponse balance = accountsStub.balance(BalanceRequest.newBuilder()
                .setAccountId(accountId)
                .build());
        System.out.println(balance.getAmountInCents());

        Iterator<OperationsResponse> operations = accountsStub.getOperations(OperationsRequest
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
