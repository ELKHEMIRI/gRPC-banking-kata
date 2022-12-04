import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: accounts.proto")
public final class accountsGrpc {

  private accountsGrpc() {}

  public static final String SERVICE_NAME = "accounts";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Empty,
      AccountCreationResponse> METHOD_CREATE =
      io.grpc.MethodDescriptor.<Empty, AccountCreationResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "accounts", "create"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              AccountCreationResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DepositRequest,
      DepositResponse> METHOD_MAKE_DEPOSIT =
      io.grpc.MethodDescriptor.<DepositRequest, DepositResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "accounts", "makeDeposit"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DepositRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DepositResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<WithdrawRequest,
      WithdrawResponse> METHOD_MAKE_WITHDRAW =
      io.grpc.MethodDescriptor.<WithdrawRequest, WithdrawResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "accounts", "makeWithdraw"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              WithdrawRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              WithdrawResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<BalanceRequest,
      BalanceResponse> METHOD_BALANCE =
      io.grpc.MethodDescriptor.<BalanceRequest, BalanceResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "accounts", "balance"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              BalanceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              BalanceResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<OperationsRequest,
      OperationsResponse> METHOD_GET_OPERATIONS =
      io.grpc.MethodDescriptor.<OperationsRequest, OperationsResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "accounts", "getOperations"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              OperationsRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              OperationsResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static accountsStub newStub(io.grpc.Channel channel) {
    return new accountsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static accountsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new accountsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static accountsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new accountsFutureStub(channel);
  }

  /**
   */
  public static abstract class accountsImplBase implements io.grpc.BindableService {

    /**
     */
    public void create(Empty request,
        io.grpc.stub.StreamObserver<AccountCreationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE, responseObserver);
    }

    /**
     */
    public void makeDeposit(DepositRequest request,
        io.grpc.stub.StreamObserver<DepositResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MAKE_DEPOSIT, responseObserver);
    }

    /**
     */
    public void makeWithdraw(WithdrawRequest request,
        io.grpc.stub.StreamObserver<WithdrawResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MAKE_WITHDRAW, responseObserver);
    }

    /**
     */
    public void balance(BalanceRequest request,
        io.grpc.stub.StreamObserver<BalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_BALANCE, responseObserver);
    }

    /**
     */
    public void getOperations(OperationsRequest request,
        io.grpc.stub.StreamObserver<OperationsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_OPERATIONS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                Empty,
                AccountCreationResponse>(
                  this, METHODID_CREATE)))
          .addMethod(
            METHOD_MAKE_DEPOSIT,
            asyncUnaryCall(
              new MethodHandlers<
                DepositRequest,
                DepositResponse>(
                  this, METHODID_MAKE_DEPOSIT)))
          .addMethod(
            METHOD_MAKE_WITHDRAW,
            asyncUnaryCall(
              new MethodHandlers<
                WithdrawRequest,
                WithdrawResponse>(
                  this, METHODID_MAKE_WITHDRAW)))
          .addMethod(
            METHOD_BALANCE,
            asyncUnaryCall(
              new MethodHandlers<
                BalanceRequest,
                BalanceResponse>(
                  this, METHODID_BALANCE)))
          .addMethod(
            METHOD_GET_OPERATIONS,
            asyncServerStreamingCall(
              new MethodHandlers<
                OperationsRequest,
                OperationsResponse>(
                  this, METHODID_GET_OPERATIONS)))
          .build();
    }
  }

  /**
   */
  public static final class accountsStub extends io.grpc.stub.AbstractStub<accountsStub> {
    private accountsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountsStub(channel, callOptions);
    }

    /**
     */
    public void create(Empty request,
        io.grpc.stub.StreamObserver<AccountCreationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeDeposit(DepositRequest request,
        io.grpc.stub.StreamObserver<DepositResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MAKE_DEPOSIT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeWithdraw(WithdrawRequest request,
        io.grpc.stub.StreamObserver<WithdrawResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MAKE_WITHDRAW, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void balance(BalanceRequest request,
        io.grpc.stub.StreamObserver<BalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_BALANCE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOperations(OperationsRequest request,
        io.grpc.stub.StreamObserver<OperationsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_OPERATIONS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class accountsBlockingStub extends io.grpc.stub.AbstractStub<accountsBlockingStub> {
    private accountsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountsBlockingStub(channel, callOptions);
    }

    /**
     */
    public AccountCreationResponse create(Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE, getCallOptions(), request);
    }

    /**
     */
    public DepositResponse makeDeposit(DepositRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MAKE_DEPOSIT, getCallOptions(), request);
    }

    /**
     */
    public WithdrawResponse makeWithdraw(WithdrawRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MAKE_WITHDRAW, getCallOptions(), request);
    }

    /**
     */
    public BalanceResponse balance(BalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_BALANCE, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<OperationsResponse> getOperations(
        OperationsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_OPERATIONS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class accountsFutureStub extends io.grpc.stub.AbstractStub<accountsFutureStub> {
    private accountsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AccountCreationResponse> create(
        Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DepositResponse> makeDeposit(
        DepositRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MAKE_DEPOSIT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<WithdrawResponse> makeWithdraw(
        WithdrawRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MAKE_WITHDRAW, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<BalanceResponse> balance(
        BalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_BALANCE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_MAKE_DEPOSIT = 1;
  private static final int METHODID_MAKE_WITHDRAW = 2;
  private static final int METHODID_BALANCE = 3;
  private static final int METHODID_GET_OPERATIONS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final accountsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(accountsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((Empty) request,
              (io.grpc.stub.StreamObserver<AccountCreationResponse>) responseObserver);
          break;
        case METHODID_MAKE_DEPOSIT:
          serviceImpl.makeDeposit((DepositRequest) request,
              (io.grpc.stub.StreamObserver<DepositResponse>) responseObserver);
          break;
        case METHODID_MAKE_WITHDRAW:
          serviceImpl.makeWithdraw((WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<WithdrawResponse>) responseObserver);
          break;
        case METHODID_BALANCE:
          serviceImpl.balance((BalanceRequest) request,
              (io.grpc.stub.StreamObserver<BalanceResponse>) responseObserver);
          break;
        case METHODID_GET_OPERATIONS:
          serviceImpl.getOperations((OperationsRequest) request,
              (io.grpc.stub.StreamObserver<OperationsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class accountsDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Accounts.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (accountsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new accountsDescriptorSupplier())
              .addMethod(METHOD_CREATE)
              .addMethod(METHOD_MAKE_DEPOSIT)
              .addMethod(METHOD_MAKE_WITHDRAW)
              .addMethod(METHOD_BALANCE)
              .addMethod(METHOD_GET_OPERATIONS)
              .build();
        }
      }
    }
    return result;
  }
}
