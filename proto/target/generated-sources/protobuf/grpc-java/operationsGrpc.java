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
public final class operationsGrpc {

  private operationsGrpc() {}

  public static final String SERVICE_NAME = "operations";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<OperationsRequest,
      OperationsResponse> METHOD_GET_OPERATIONS =
      io.grpc.MethodDescriptor.<OperationsRequest, OperationsResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "operations", "getOperations"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              OperationsRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              OperationsResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static operationsStub newStub(io.grpc.Channel channel) {
    return new operationsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static operationsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new operationsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static operationsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new operationsFutureStub(channel);
  }

  /**
   */
  public static abstract class operationsImplBase implements io.grpc.BindableService {

    /**
     */
    public void getOperations(OperationsRequest request,
        io.grpc.stub.StreamObserver<OperationsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_OPERATIONS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
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
  public static final class operationsStub extends io.grpc.stub.AbstractStub<operationsStub> {
    private operationsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private operationsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected operationsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new operationsStub(channel, callOptions);
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
  public static final class operationsBlockingStub extends io.grpc.stub.AbstractStub<operationsBlockingStub> {
    private operationsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private operationsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected operationsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new operationsBlockingStub(channel, callOptions);
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
  public static final class operationsFutureStub extends io.grpc.stub.AbstractStub<operationsFutureStub> {
    private operationsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private operationsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected operationsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new operationsFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_OPERATIONS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final operationsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(operationsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
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

  private static final class operationsDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Schema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (operationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new operationsDescriptorSupplier())
              .addMethod(METHOD_GET_OPERATIONS)
              .build();
        }
      }
    }
    return result;
  }
}
