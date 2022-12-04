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
public final class depositsGrpc {

  private depositsGrpc() {}

  public static final String SERVICE_NAME = "deposits";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DepositRequest,
      DepositResponse> METHOD_MAKE_DEPOSIT =
      io.grpc.MethodDescriptor.<DepositRequest, DepositResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "deposits", "makeDeposit"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DepositRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              DepositResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static depositsStub newStub(io.grpc.Channel channel) {
    return new depositsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static depositsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new depositsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static depositsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new depositsFutureStub(channel);
  }

  /**
   */
  public static abstract class depositsImplBase implements io.grpc.BindableService {

    /**
     */
    public void makeDeposit(DepositRequest request,
        io.grpc.stub.StreamObserver<DepositResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MAKE_DEPOSIT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_MAKE_DEPOSIT,
            asyncUnaryCall(
              new MethodHandlers<
                DepositRequest,
                DepositResponse>(
                  this, METHODID_MAKE_DEPOSIT)))
          .build();
    }
  }

  /**
   */
  public static final class depositsStub extends io.grpc.stub.AbstractStub<depositsStub> {
    private depositsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private depositsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected depositsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new depositsStub(channel, callOptions);
    }

    /**
     */
    public void makeDeposit(DepositRequest request,
        io.grpc.stub.StreamObserver<DepositResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MAKE_DEPOSIT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class depositsBlockingStub extends io.grpc.stub.AbstractStub<depositsBlockingStub> {
    private depositsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private depositsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected depositsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new depositsBlockingStub(channel, callOptions);
    }

    /**
     */
    public DepositResponse makeDeposit(DepositRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MAKE_DEPOSIT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class depositsFutureStub extends io.grpc.stub.AbstractStub<depositsFutureStub> {
    private depositsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private depositsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected depositsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new depositsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DepositResponse> makeDeposit(
        DepositRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MAKE_DEPOSIT, getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_DEPOSIT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final depositsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(depositsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_DEPOSIT:
          serviceImpl.makeDeposit((DepositRequest) request,
              (io.grpc.stub.StreamObserver<DepositResponse>) responseObserver);
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

  private static final class depositsDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Schema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (depositsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new depositsDescriptorSupplier())
              .addMethod(METHOD_MAKE_DEPOSIT)
              .build();
        }
      }
    }
    return result;
  }
}
