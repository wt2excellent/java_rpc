package part1.common.serializer.mySerializer;


import part1.common.serializer.mySerializer.impl.JsonSerializer;
import part1.common.serializer.mySerializer.impl.KryoSerializer;
import part1.common.serializer.mySerializer.impl.ObjectSerializer;
import part1.common.serializer.mySerializer.impl.ProtostuffSerializer;

/**
 * @version 1.0
 * @create 2024/6/2 22:31
 */
public interface Serializer {
    // 把对象序列化成字节数组
    byte[] serialize(Object obj);
    // 从字节数组反序列化成消息, 使用java自带序列化方式不用messageType也能得到相应的对象（序列化字节数组里包含类信息）
    // 其它方式需指定消息格式，再根据message转化成相应的对象
    Object deserialize(byte[] bytes, int messageType);
    // 返回使用的序列器，是哪个
    // 0：java自带序列化方式, 1: json序列化方式, 3:Protostuff序列化方式
    int getType();
    // 根据序号取出序列化器，暂时有两种实现方式，需要其它方式，实现这个接口即可
    static Serializer getSerializerByCode(int code){
        switch (code){
            case 0:
                return new ObjectSerializer();
            case 1:
                return new JsonSerializer();
            case 2:
                return new ProtostuffSerializer();
            case 3:
                return new KryoSerializer();
            default:
                return null;
        }
    }

    static String getSerializerNameByCode(int code){
        switch (code){
            case 0:
                return "Java_Jdk";
            case 1:
                return "JSON";
            case 2:
                return "Protostuff";
            case 3:
                return "Kryo";
            default:
                return null;
        }
    }
}
