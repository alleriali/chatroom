# chatroom

1.using command "./gradlew installDist" to generate a folder build
2.Firstly run the server: ./build/install/examples/bin/chatroom-server
3.Then run the client: ./build/install/examples/bin/chatroom-client

Containize using Docker:
create mysql image before creating server image
create mysql image : docker build -f /examples/docker_sql/Dockerfile --tag mysql:latest .
create server image: docker build -f /examples/docker_server/Dockerfile --tag chatroom_server:latest .



