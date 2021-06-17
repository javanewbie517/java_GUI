package GUI;

import java.io.IOException;
import java.net.Socket;


/**
 * client1
 *
 * @author 一条寂寞的鱼
 * @date 2021/06/17
 */
public class Client1 {
    /**
     * 套接字
     */
    private Socket socket;
    /**
     * 消息大小
     */
    private static final int MESSAGE_SIZE = 1024;//每次允许接受数据的最大长度

    /**
     * client1
     */
    public Client1() {
        try {

            socket = new Socket("123.60.219.79", 3389);
            if (socket.isConnected() == true) {
                System.out.println("连接成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取套接字
     *
     * @return {@link Socket}
     */
    public Socket getSocket() {
		return socket;
	}

}

