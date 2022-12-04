import accounts.Accounts;
import accounts.AccountsAPI;
import accounts.AccountsSPI;
import accounts.InMemoryAccountsAdapter;
import balances.Balances;
import balances.BalancesAPI;
import deposit.Deposits;
import deposit.DepositsAPI;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import operations.InMemoryOperationAdapter;
import operations.Operations;
import operations.OperationsAPI;
import operations.OperationsSPI;
import withdrawals.Withdrawals;
import withdrawals.WithdrawalsAPI;

import java.io.IOException;

public class GRPCServecApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        OperationsSPI operationsSPI = new InMemoryOperationAdapter();
        AccountsSPI accountsSPI = new InMemoryAccountsAdapter();
        AccountsAPI accountsAPI = new Accounts(accountsSPI);
        OperationsAPI operationsAPI = new Operations(operationsSPI);
        BalancesAPI balancesAPI = new Balances(operationsAPI);
        DepositsAPI depositsAPI = new Deposits(operationsAPI);
        WithdrawalsAPI withdrawalsAPI = new Withdrawals(operationsAPI);

            Server grpcServer = ServerBuilder.forPort(9090)
                .addService(new AccountsService(accountsAPI, operationsAPI, balancesAPI, depositsAPI, withdrawalsAPI))
                .build();
        grpcServer.start();
        grpcServer.awaitTermination();
    }
}
