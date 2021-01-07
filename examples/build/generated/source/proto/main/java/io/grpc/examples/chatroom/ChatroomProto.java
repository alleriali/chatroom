// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chatroom.proto

package io.grpc.examples.chatroom;

public final class ChatroomProto {
  private ChatroomProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_HelloReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_ChatMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_ChatMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_ChatMessageFromServer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_ChatMessageFromServer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_AuthenticateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_AuthenticateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_chatroom_AuthenticateReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_chatroom_AuthenticateReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016chatroom.proto\022\010chatroom\"\034\n\014HelloReque" +
      "st\022\014\n\004name\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007messag" +
      "e\030\001 \001(\t\"g\n\013ChatMessage\022#\n\004type\030\001 \001(\0162\025.c" +
      "hatroom.MessageType\022\017\n\007message\030\013 \001(\t\022\020\n\010" +
      "username\030\014 \001(\t\022\020\n\010password\030\r \001(\t\"[\n\025Chat" +
      "MessageFromServer\022#\n\004type\030\002 \001(\0162\025.chatro" +
      "om.MessageType\022\014\n\004from\030\013 \001(\t\022\017\n\007message\030" +
      "\014 \001(\t\"\'\n\023AuthenticateRequest\022\020\n\010username" +
      "\030\001 \001(\t\"$\n\021AuthenticateReply\022\017\n\007isValid\030\001" +
      " \001(\010*,\n\013MessageType\022\010\n\004JOIN\020\000\022\t\n\005LEAVE\020\001" +
      "\022\010\n\004TEXT\020\0022E\n\007Greeter\022:\n\010SayHello\022\026.chat" +
      "room.HelloRequest\032\024.chatroom.HelloReply\"" +
      "\0002\243\001\n\021ChatStreamService\022B\n\004chat\022\025.chatro" +
      "om.ChatMessage\032\037.chatroom.ChatMessageFro" +
      "mServer(\0010\001\022J\n\014authenticate\022\035.chatroom.A" +
      "uthenticateRequest\032\033.chatroom.Authentica" +
      "teReplyB2\n\031io.grpc.examples.chatroomB\rCh" +
      "atroomProtoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_chatroom_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_chatroom_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_chatroom_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_chatroom_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_chatroom_ChatMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_chatroom_ChatMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_ChatMessage_descriptor,
        new java.lang.String[] { "Type", "Message", "Username", "Password", });
    internal_static_chatroom_ChatMessageFromServer_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_chatroom_ChatMessageFromServer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_ChatMessageFromServer_descriptor,
        new java.lang.String[] { "Type", "From", "Message", });
    internal_static_chatroom_AuthenticateRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_chatroom_AuthenticateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_AuthenticateRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_chatroom_AuthenticateReply_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_chatroom_AuthenticateReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_chatroom_AuthenticateReply_descriptor,
        new java.lang.String[] { "IsValid", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}