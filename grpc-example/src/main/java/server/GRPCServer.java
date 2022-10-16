package server;

import java.io.IOException;
import java.io.InterruptedIOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.userService;

public class GRPCServer {
    public static void main (String args[] ) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9090)
                .addService( new userService()).build();
        server.start();

        System.out.println("Server started at port : " + server.getPort());

        server.awaitTermination();
    }
}
