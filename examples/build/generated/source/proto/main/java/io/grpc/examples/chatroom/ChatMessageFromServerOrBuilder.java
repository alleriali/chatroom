// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chatroom.proto

package io.grpc.examples.chatroom;

public interface ChatMessageFromServerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:chatroom.ChatMessageFromServer)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.chatroom.MessageType type = 2;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.chatroom.MessageType type = 2;</code>
   * @return The type.
   */
  io.grpc.examples.chatroom.MessageType getType();

  /**
   * <code>string from = 11;</code>
   * @return The from.
   */
  java.lang.String getFrom();
  /**
   * <code>string from = 11;</code>
   * @return The bytes for from.
   */
  com.google.protobuf.ByteString
      getFromBytes();

  /**
   * <code>string message = 12;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 12;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}