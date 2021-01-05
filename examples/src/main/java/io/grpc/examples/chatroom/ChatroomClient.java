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

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.grpc.stub.StreamObserver;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.*;



public class ChatroomClient {
    private static final Logger logger = Logger.getLogger(ChatroomClient.class.getName());

    private final ChatStreamServiceGrpc.ChatStreamServiceStub asyncStub;
    private final ChatStreamServiceGrpc.ChatStreamServiceBlockingStub blockingStub;

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    public ChatroomClient(Channel channel){
        blockingStub = ChatStreamServiceGrpc.newBlockingStub(channel);
        asyncStub = ChatStreamServiceGrpc.newStub(channel);
    }


    /**
     * Say hello to server.
     */
    public void chat(String name) {
        logger.info(name + " entered the chatroom");
        StreamObserver<ChatMessage> requestObserver =
                asyncStub.chat(new StreamObserver<ChatMessageFromServer>() {
                    @Override
                    public void onNext(ChatMessageFromServer message) {
                        logger.info(message.getMessage());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                });
        ChatMessage message = ChatMessage.newBuilder().setType(MessageType.JOIN).setUsername(name).build();
        requestObserver.onNext(message);
        while (true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            message = ChatMessage.newBuilder().setType(MessageType.TEXT).setUsername(name).setMessage(input).build();
            requestObserver.onNext(message);
            if (input.equals("end")) {
                break;
            }
        }
        logger.info("aaaa " + name + " ...");
        requestObserver.onCompleted();
    }

    public boolean authenticate(String username) {
        AuthenticateRequest request = AuthenticateRequest.newBuilder().setUsername(username).build();
        AuthenticateReply response;
        try {
            response = blockingStub.authenticate(request);
            return response.getIsValid();
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }
        return false;

    }


    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
    public static void main(String[] args) throws Exception {
        String target = "localhost:50053";

//     Create a communication channel to the server, known as a Channel. Channels are thread-safe
//     and reusable. It is common to create channels at the beginning of your application and reuse
//     them until the application shuts down.


        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                //Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                //needing certificates.
                .usePlaintext()
                .build();
        logger.info("Connected to " + target);



        try {
            ChatroomClient client = new ChatroomClient(channel);
            logger.info("Please input your username!");
            String username ="";
            while (true) {
                Scanner sc = new Scanner(System.in);
                username = sc.nextLine();
                if (client.authenticate(username)) {
                    logger.info("your input username is valid!");
                    break;
                }
                logger.info("your input username already exists! please use another username!");
            }
            client.chat(username);
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
