FROM ubuntu:20.04
FROM openjdk:11

COPY . /home/ying/chatroom

WORKDIR /home/ying/chatroom
EXPOSE 50053
CMD ["./build/install/examples/bin/chatroom-server"]
