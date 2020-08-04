package com.cheerful.study.javabase.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Dandwj
 * @Date 2020/8/4 20:18
 * @Description
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        // 创建socket，并将socket绑定到65000端口
        ServerSocket ss = new ServerSocket(65000);
        // 让socket一直等待并处理客户端发送过来的请求
        while(true) {
            // 监听65000端口，直到客户端进行连接后返回一个Socket实例
            Socket socket = ss.accept();
            new LengthCalculaotr(socket).start();
        }
    }
}
