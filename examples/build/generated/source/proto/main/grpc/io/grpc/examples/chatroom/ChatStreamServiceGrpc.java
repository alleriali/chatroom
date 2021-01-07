package io.grpc.examples.chatroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.34.0)",
    comments = "Source: chatroom.proto")
public final class ChatStreamServiceGrpc {

  private ChatStreamServiceGrpc() {}

  public static final String SERVICE_NAME = "chatroom.ChatStreamService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.chatroom.ChatMessage,
      io.grpc.examples.chatroom.ChatMessageFromServer> getChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "chat",
      requestType = io.grpc.examples.chatroom.ChatMessage.class,
      responseType = io.grpc.examples.chatroom.ChatMessageFromServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.examples.chatroom.ChatMessage,
      io.grpc.examples.chatroom.ChatMessageFromServer> getChatMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.chatroom.ChatMessage, io.grpc.examples.chatroom.ChatMessageFromServer> getChatMethod;
    if ((getChatMethod = ChatStreamServiceGrpc.getChatMethod) == null) {
      synchronized (ChatStreamServiceGrpc.class) {
        if ((getChatMethod = ChatStreamServiceGrpc.getChatMethod) == null) {
          ChatStreamServiceGrpc.getChatMethod = getChatMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.chatroom.ChatMessage, io.grpc.examples.chatroom.ChatMessageFromServer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "chat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.chatroom.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.chatroom.ChatMessageFromServer.getDefaultInstance()))
              .setSchemaDescriptor(new ChatStreamServiceMethodDescriptorSupplier("chat"))
              .build();
        }
      }
    }
    return getChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.chatroom.AuthenticateRequest,
      io.grpc.examples.chatroom.AuthenticateReply> getAuthenticateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "authenticate",
      requestType = io.grpc.examples.chatroom.AuthenticateRequest.class,
      responseType = io.grpc.examples.chatroom.AuthenticateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.examples.chatroom.AuthenticateRequest,
      io.grpc.examples.chatroom.AuthenticateReply> getAuthenticateMethod() {
    io.grpc.MethodDescriptor<io.grpc.examples.chatroom.AuthenticateRequest, io.grpc.examples.chatroom.AuthenticateReply> getAuthenticateMethod;
    if ((getAuthenticateMethod = ChatStreamServiceGrpc.getAuthenticateMethod) == null) {
      synchronized (ChatStreamServiceGrpc.class) {
        if ((getAuthenticateMethod = ChatStreamServiceGrpc.getAuthenticateMethod) == null) {
          ChatStreamServiceGrpc.getAuthenticateMethod = getAuthenticateMethod =
              io.grpc.MethodDescriptor.<io.grpc.examples.chatroom.AuthenticateRequest, io.grpc.examples.chatroom.AuthenticateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "authenticate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.chatroom.AuthenticateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.chatroom.AuthenticateReply.getDefaultInstance()))
              .setSchemaDescriptor(new ChatStreamServiceMethodDescriptorSupplier("authenticate"))
              .build();
        }
      }
    }
    return getAuthenticateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatStreamServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatStreamServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatStreamServiceStub>() {
        @java.lang.Override
        public ChatStreamServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatStreamServiceStub(channel, callOptions);
        }
      };
    return ChatStreamServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatStreamServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatStreamServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatStreamServiceBlockingStub>() {
        @java.lang.Override
        public ChatStreamServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatStreamServiceBlockingStub(channel, callOptions);
        }
      };
    return ChatStreamServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatStreamServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatStreamServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatStreamServiceFutureStub>() {
        @java.lang.Override
        public ChatStreamServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatStreamServiceFutureStub(channel, callOptions);
        }
      };
    return ChatStreamServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChatStreamServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.ChatMessage> chat(
        io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.ChatMessageFromServer> responseObserver) {
      return asyncUnimplementedStreamingCall(getChatMethod(), responseObserver);
    }

    /**
     */
    public void authenticate(io.grpc.examples.chatroom.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.AuthenticateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAuthenticateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.grpc.examples.chatroom.ChatMessage,
                io.grpc.examples.chatroom.ChatMessageFromServer>(
                  this, METHODID_CHAT)))
          .addMethod(
            getAuthenticateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.chatroom.AuthenticateRequest,
                io.grpc.examples.chatroom.AuthenticateReply>(
                  this, METHODID_AUTHENTICATE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatStreamServiceStub extends io.grpc.stub.AbstractAsyncStub<ChatStreamServiceStub> {
    private ChatStreamServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatStreamServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatStreamServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.ChatMessage> chat(
        io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.ChatMessageFromServer> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChatMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void authenticate(io.grpc.examples.chatroom.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.AuthenticateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAuthenticateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatStreamServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChatStreamServiceBlockingStub> {
    private ChatStreamServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatStreamServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatStreamServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.chatroom.AuthenticateReply authenticate(io.grpc.examples.chatroom.AuthenticateRequest request) {
      return blockingUnaryCall(
          getChannel(), getAuthenticateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatStreamServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ChatStreamServiceFutureStub> {
    private ChatStreamServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatStreamServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatStreamServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.chatroom.AuthenticateReply> authenticate(
        io.grpc.examples.chatroom.AuthenticateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAuthenticateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTHENTICATE = 0;
  private static final int METHODID_CHAT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatStreamServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatStreamServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTHENTICATE:
          serviceImpl.authenticate((io.grpc.examples.chatroom.AuthenticateRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.AuthenticateReply>) responseObserver);
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
        case METHODID_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chat(
              (io.grpc.stub.StreamObserver<io.grpc.examples.chatroom.ChatMessageFromServer>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatStreamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatStreamServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.chatroom.ChatroomProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatStreamService");
    }
  }

  private static final class ChatStreamServiceFileDescriptorSupplier
      extends ChatStreamServiceBaseDescriptorSupplier {
    ChatStreamServiceFileDescriptorSupplier() {}
  }

  private static final class ChatStreamServiceMethodDescriptorSupplier
      extends ChatStreamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatStreamServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatStreamServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatStreamServiceFileDescriptorSupplier())
              .addMethod(getChatMethod())
              .addMethod(getAuthenticateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
