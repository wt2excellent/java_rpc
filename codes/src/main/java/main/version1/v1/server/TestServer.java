package main.version1.v1.server;

import main.version1.v1.common.service.UserService;
import main.version1.v1.common.service.impl.UserServiceImpl;
import main.version1.v1.server.server.RPCServer;
import main.version1.v1.server.server.impl.SimpleRPCServerImpl;
import main.version1.v1.server.provider.ServiceProvider;
import main.version1.v1.server.server.impl.ThreadPoolRPCServerImpl;

public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.providerServiceInterface(userService);

        RPCServer rpcServer = new ThreadPoolRPCServerImpl(serviceProvider);
        rpcServer.start(9999);
    }
}
