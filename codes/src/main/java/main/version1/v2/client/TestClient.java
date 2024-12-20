package main.version1.v2.client;
import lombok.extern.slf4j.Slf4j;
import main.version1.v2.client.proxy.ClientProxy;
import main.version1.v2.common.pojo.User;
import main.version1.v2.common.service.UserService;


@Slf4j
public class TestClient {
    public static void main(String[] args) {
        ClientProxy clientProxy=new ClientProxy("127.0.0.1",9999,0);
        UserService proxy=clientProxy.getProxy(UserService.class);

        User user = proxy.getUserById(1);
        System.out.println("从服务端得到的user="+user.toString());

        User u=User.builder().id(100).userName("wxx").sex(true).build();
        Integer id = proxy.insertUserById(u);
        System.out.println("向服务端插入user的id"+id);
    }
}
