package com.cheerful.study.javabase.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @Author Dandwj
 * @Date 2020/8/4 21:19
 * @Description
 */
public class UdpServer {

    public static void main(String[] args) throws IOException {
        // 服务端接受客户端发送的数据报
        DatagramSocket socket = new DatagramSocket(65001);
        byte[] buff = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);

        // 接收客户端发送过来的内容，并将内容封装进DatagramPacket对象中
        socket.receive(datagramPacket);

        // 从数据报对象中获取到真正存储的数据
        byte[] data = datagramPacket.getData();
        // 将数据从二进制转换成字符串形式
        String content = new String(data, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
        System.out.println(content);

        // 将要发送的数据转成二进制形式
        byte[] replayContent = String.valueOf(content.length()).getBytes();
        // 服务端给客户端发送数据报
        // 从之前接收的DatagramPacket对象中获取掉数据的来源地址和端口号
        DatagramPacket replayPacket = new DatagramPacket(replayContent,
                replayContent.length, datagramPacket.getAddress(), datagramPacket.getPort());

        socket.send(replayPacket);
    }
}
