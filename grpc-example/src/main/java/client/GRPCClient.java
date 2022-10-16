package client;



import com.grpcpractice.grpcexample.grpc.APIResponse;
import com.grpcpractice.grpcexample.grpc.LoginRequest;
import com.grpcpractice.grpcexample.grpc.UserGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
    public static void main(String args[]) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        //stubs
        UserGrpc.UserBlockingStub stubs = UserGrpc.newBlockingStub(channel);

        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("ayush").setPassword("ayush").build();
        APIResponse response = stubs.login(loginRequest);
        System.out.println(response.getCode());
        System.out.println(response.getMessage());
    }
}
