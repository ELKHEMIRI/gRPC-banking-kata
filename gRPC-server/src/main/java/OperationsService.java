import accounts.AccountId;
import io.grpc.stub.StreamObserver;
import operations.Operation;
import operations.OperationsAPI;

import java.util.Collection;

import static java.lang.Thread.sleep;

public class OperationsService extends operationsGrpc.operationsImplBase {
    private final OperationsAPI operationsAPI;

    public OperationsService(OperationsAPI operationsAPI) {
        this.operationsAPI = operationsAPI;
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
