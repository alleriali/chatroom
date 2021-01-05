/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.grpc.examples.chatroom;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class ChatroomServer {
    private static final Logger logger = Logger.getLogger(ChatroomServer.class.getName());

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50053;
        server = ServerBuilder.forPort(port)
                .addService(new ChatStreamServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    ChatroomServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        logger.info("Create ChatroomServer");
        final ChatroomServer server = new ChatroomServer();
        server.start();
        server.blockUntilShutdown();
    }


    static class ChatStreamServiceImpl extends ChatStreamServiceGrpc.ChatStreamServiceImplBase {
        Map<StreamObserver<ChatMessageFromServer>, String> observers;
        MySqlConnect connect;
        private int id;

        public ChatStreamServiceImpl() {
            observers = new HashMap<>();
            connect = new MySqlConnect(logger);
            id = connect.getId();
        }

        private synchronized void sendMessageFromServer(ChatMessageFromServer message) {
            for (StreamObserver<ChatMessageFromServer> existing_observers : observers.keySet()) {
                existing_observers.onNext(message);
            }
        }

        private synchronized int IdIncrement() {
            this.id++;
            return this.id;
        }

        private synchronized void addResponseObserver(final StreamObserver<ChatMessageFromServer> responseObserver, String username) {
            observers.put(responseObserver, username);
        }

        private synchronized void removeResponseObserver(final StreamObserver<ChatMessageFromServer> responseObserver) {
            observers.remove(responseObserver);
        }

        @Override
        public StreamObserver<ChatMessage> chat(final StreamObserver<ChatMessageFromServer> responseObserver) {
            return new StreamObserver<ChatMessage>() {
                @Override
                public void onNext(ChatMessage chatMessage) {
                    logger.info("Receive client message...");
                    if (chatMessage.getType() == MessageType.JOIN) {
                        String username = chatMessage.getUsername();
                        ChatMessageFromServer message = ChatMessageFromServer.newBuilder().setMessage(username + " joined.").build();
                        logger.info("Broadcast JOIN message start...");
                        sendMessageFromServer(message);
                        logger.info("Broadcast JOIN message finish...");
                        addResponseObserver(responseObserver, username);
                    } else if (chatMessage.getType() == MessageType.LEAVE) {

                    } else {
                        logger.info("client is sendig messages ");
                        ChatMessageFromServer message = ChatMessageFromServer.newBuilder().setMessage("from " + chatMessage.getUsername() + " : " + chatMessage.getMessage()).build();
                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formattedDate = myDateObj.format(myFormatObj);
                        int id = IdIncrement();
                        connect.storeMessage(id, chatMessage.getMessage(), chatMessage.getUsername(), formattedDate);
                        logger.info("Broadcast TEXT message start...");
                        sendMessageFromServer(message);
                        logger.info("Broadcast TEXT message finish...");
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    String user_name = observers.get(responseObserver);
                    ChatMessageFromServer message = ChatMessageFromServer.newBuilder().setMessage(user_name + " left.").build();
                    logger.info("Broadcast LEAVE/ERROR message start...");
                    removeResponseObserver(responseObserver);
                    sendMessageFromServer(message);
                    logger.info("Broadcast LEAVE/ERROR message finish...");
                }

                @Override
                public void onCompleted() {
                    String user_name = observers.get(responseObserver);
                    ChatMessageFromServer message = ChatMessageFromServer.newBuilder().setMessage(user_name + " left.").build();
                    logger.info("Broadcast LEAVE/COMPLETED message start...");
                    removeResponseObserver(responseObserver);
                    sendMessageFromServer(message);
                    logger.info("Broadcast LEAVE/COMPLETED message start...");
                }
            };
        }

        @Override
        public void authenticate(AuthenticateRequest request, StreamObserver<AuthenticateReply> responseObserver) {
            String username = request.getUsername();
            boolean existed = connect.findUsername(username);
            if(!existed){
                connect.addUsername(username);
            }
            AuthenticateReply reply = AuthenticateReply.newBuilder().setIsValid(!existed).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

    }
}
