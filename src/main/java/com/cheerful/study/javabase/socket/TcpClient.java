package com.cheerful.study.javabase.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author Dandwj
 * @Date 2020/8/4 20:51
 * @Description
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {
        // 创建socket，并指定连接服务器地址
        Socket socket = new Socket("127.0.0.1", 65000);
        // 获取输入流
        InputStream inputStream = socket.getInputStream();
        // 获取输出流
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("hello world!".getBytes());

        int length = 0;
        byte[] buff = new byte[1024];
        length = inputStream.read(buff);
        String content = new String(buff, 0, length, StandardCharsets.UTF_8);
        System.out.println(content);

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
