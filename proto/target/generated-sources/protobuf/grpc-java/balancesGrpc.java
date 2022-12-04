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
    comments = "Source: schema.proto")
public final class balancesGrpc {

  private balancesGrpc() {}

  public static final String SERVICE_NAME = "balances";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<BalanceRequest,
      BalanceResponse> METHOD_BALANCE =
      io.grpc.MethodDescriptor.<BalanceRequest, BalanceResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "balances", "balance"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              BalanceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              BalanceResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static balancesStub newStub(io.grpc.Channel channel) {
    return new balancesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static balancesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new balancesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static balancesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new balancesFutureStub(channel);
  }

  /**
   */
  public static abstract class balancesImplBase implements io.grpc.BindableService {

    /**
     */
    public void balance(BalanceRequest request,
        io.grpc.stub.StreamObserver<BalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_BALANCE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_BALANCE,
            asyncUnaryCall(
              new MethodHandlers<
                BalanceRequest,
                BalanceResponse>(
                  this, METHODID_BALANCE)))
          .build();
    }
  }

  /**
   */
  public static final class balancesStub extends io.grpc.stub.AbstractStub<balancesStub> {
    private balancesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private balancesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected balancesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new balancesStub(channel, callOptions);
    }

    /**
     */
    public void balance(BalanceRequest request,
        io.grpc.stub.StreamObserver<BalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_BALANCE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class balancesBlockingStub extends io.grpc.stub.AbstractStub<balancesBlockingStub> {
    private balancesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private balancesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected balancesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new balancesBlockingStub(channel, callOptions);
    }

    /**
     */
    public BalanceResponse balance(BalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_BALANCE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class balancesFutureStub extends io.grpc.stub.AbstractStub<balancesFutureStub> {
    private balancesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private balancesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected balancesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new balancesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<BalanceResponse> balance(
        BalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_BALANCE, getCallOptions()), request);
    }
  }

  private static final int METHODID_BALANCE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final balancesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(balancesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BALANCE:
          serviceImpl.balance((BalanceRequest) request,
              (io.grpc.stub.StreamObserver<BalanceResponse>) responseObserver);
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

  private static final class balancesDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Schema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (balancesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new balancesDescriptorSupplier())
              .addMethod(METHOD_BALANCE)
              .build();
        }
      }
    }
    return result;
  }
}
