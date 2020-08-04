package com.cheerful.study.javabase.socket;

import lombok.AllArgsConstructor;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author Dandwj
 * @Date 2020/8/4 20:21
 * @Description 返回接收数据的长度
 */
@AllArgsConstructor
public class LengthCalculaotr extends Thread{

    public Socket socket;

    @Override
    public void run() {
        try {
            // 获取socket输出流
            OutputStream outputStream = socket.getOutputStream();
            // 获取socket输入流
            InputStream inputStream = socket.getInputStream();
            // 获取的输入流数据长度
            int length = 0;
            byte[] buff = new byte[1024];
            length = inputStream.read(buff);
            String content = new String(buff, 0, length, StandardCharsets.UTF_8);
            System.out.println(content);

            outputStream.write(String.valueOf(content.length()).getBytes());

            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
