package GUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeTingwei on 2017/12/9.
 * 多线程服务器,实现多客户端聊天
 */
public class Server {

    List<ReceiveThread> receiveList = new ArrayList<>();//存放已连接客户端类
    private final static int MESSAGE_SIZE = 1024;//每次允许接受数据的最大长度
    int active = 0;//客户端编号
    String message="";

    public static void main(String[] args) {
        new Server();
    }

    //服务端处理逻辑
    Server() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3389);//用来监听的套接字，指定端口号
            while (true) {
                Socket socket = serverSocket.accept();//监听客户端连接，阻塞线程

                //在其他线程处理接收来自客户端的消息
                ReceiveThread receiveThread = new ReceiveThread(socket, active);
                receiveThread.start();
                receiveList.add(receiveThread);

                //有客户端新上线，服务器就通知其他客户端
                active++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //接受消息的线程（同时也有记录对应客户端socket的作用）
    class ReceiveThread extends Thread {
        int num;
        Socket socket;//客户端对应的套接字
        boolean continueReceive = true;//标识是否还维持连接需要接收

        public ReceiveThread(Socket socket, int num) {
            this.socket = socket;
            this.num = num;
        }

        @Override
        public void run() {
            super.run();
            //接收客户端发送的消息
            InputStream in=null;
            try {
                 in = socket.getInputStream();
                DataInputStream stream = new DataInputStream(in);
                while (true){
                    message = stream.readUTF();
                    for (ReceiveThread thread : receiveList) {
                        new SendThread(thread.socket,active+"#"+message).start();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {//关闭资源
                    if (in != null) {
                        in.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //发送消息的线程
    class SendThread extends Thread {
        Socket socket;
        String str;

        public SendThread(Socket socket, String str) {
            this.socket = socket;
            this.str = str;
        }

        @Override
        public void run() {
            super.run();
            try {

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF(str);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}

