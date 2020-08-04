package com.cheerful.study.javabase.socket;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author Dandwj
 * @Date 2020/8/4 21:42
 * @Description
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        // 客户端发送数据报给服务端
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        byte[] sendByte = "hello world!".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length, inetAddress, 65001);
        datagramSocket.send(sendPacket);

        // 接收数据
        byte[] receiveByte = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(receiveByte, receiveByte.length,
                inetAddress, 65001);

        datagramSocket.receive(datagramPacket);
        String receiveContent = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
        System.out.println(receiveContent);
    }
}
