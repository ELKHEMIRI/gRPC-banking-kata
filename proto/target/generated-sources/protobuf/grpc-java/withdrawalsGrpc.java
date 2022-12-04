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
public final class withdrawalsGrpc {

  private withdrawalsGrpc() {}

  public static final String SERVICE_NAME = "withdrawals";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<WithdrawRequest,
      WithdrawResponse> METHOD_MAKE_WITHDRAW =
      io.grpc.MethodDescriptor.<WithdrawRequest, WithdrawResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "withdrawals", "makeWithdraw"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              WithdrawRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              WithdrawResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static withdrawalsStub newStub(io.grpc.Channel channel) {
    return new withdrawalsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static withdrawalsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new withdrawalsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static withdrawalsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new withdrawalsFutureStub(channel);
  }

  /**
   */
  public static abstract class withdrawalsImplBase implements io.grpc.BindableService {

    /**
     */
    public void makeWithdraw(WithdrawRequest request,
        io.grpc.stub.StreamObserver<WithdrawResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MAKE_WITHDRAW, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_MAKE_WITHDRAW,
            asyncUnaryCall(
              new MethodHandlers<
                WithdrawRequest,
                WithdrawResponse>(
                  this, METHODID_MAKE_WITHDRAW)))
          .build();
    }
  }

  /**
   */
  public static final class withdrawalsStub extends io.grpc.stub.AbstractStub<withdrawalsStub> {
    private withdrawalsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private withdrawalsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected withdrawalsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new withdrawalsStub(channel, callOptions);
    }

    /**
     */
    public void makeWithdraw(WithdrawRequest request,
        io.grpc.stub.StreamObserver<WithdrawResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MAKE_WITHDRAW, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class withdrawalsBlockingStub extends io.grpc.stub.AbstractStub<withdrawalsBlockingStub> {
    private withdrawalsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private withdrawalsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected withdrawalsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new withdrawalsBlockingStub(channel, callOptions);
    }

    /**
     */
    public WithdrawResponse makeWithdraw(WithdrawRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MAKE_WITHDRAW, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class withdrawalsFutureStub extends io.grpc.stub.AbstractStub<withdrawalsFutureStub> {
    private withdrawalsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private withdrawalsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected withdrawalsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new withdrawalsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<WithdrawResponse> makeWithdraw(
        WithdrawRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MAKE_WITHDRAW, getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_WITHDRAW = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final withdrawalsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(withdrawalsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_WITHDRAW:
          serviceImpl.makeWithdraw((WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<WithdrawResponse>) responseObserver);
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

  private static final class withdrawalsDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Schema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (withdrawalsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new withdrawalsDescriptorSupplier())
              .addMethod(METHOD_MAKE_WITHDRAW)
              .build();
        }
      }
    }
    return result;
  }
}
