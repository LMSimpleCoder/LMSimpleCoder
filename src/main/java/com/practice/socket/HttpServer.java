package com.practice.socket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luoming
 */
public class HttpServer {

    /** WEB_ROOT 是放html和file文件的地方
     *  这个应用中，WEB_ROOT 就是项目目录下的webroot文件夹
     */
    /**
     * 获取项目路径下的webroot目录
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator  + "webroot";
    // 关闭命令
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    // 接收关闭命令
    private boolean shutdown = false;
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }
    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket =  new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // Loop waiting for a request
        while (!shutdown) {
            Socket socket;
            InputStream input;
            OutputStream output;
            try {
                StringBuilder s = new StringBuilder();
                //等待接收
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                // 创建Request对象(Request实现代码在下面)
                Request request = new Request(input);

                // 创建Response对象
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                request.parse();
                // 关闭socket
                socket.close();
                //检测先前的URI是否是关闭命令
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
