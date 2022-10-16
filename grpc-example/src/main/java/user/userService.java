package user;

import com.grpcpractice.grpcexample.grpc.APIResponse;
import com.grpcpractice.grpcexample.grpc.Empty;
import com.grpcpractice.grpcexample.grpc.LoginRequest;
import com.grpcpractice.grpcexample.grpc.UserGrpc;

import io.grpc.stub.StreamObserver;

public class userService extends UserGrpc.UserImplBase {

    @Override
    public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("log in");

        String username = request.getUsername();
        String password = request.getPassword();

        APIResponse.Builder response = APIResponse.newBuilder();
        if(username.equals(password)) {
            //success
            response.setMessage("LOGGED IN ").setCode(200);
        } else {
            //failure
            response.setMessage("INCORRECT CREDS ").setCode(400);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("log out");
    }
}
