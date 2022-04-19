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

    /** WEB_ROOT �Ƿ�html��file�ļ��ĵط�
     *  ���Ӧ���У�WEB_ROOT ������ĿĿ¼�µ�webroot�ļ���
     */
    /**
     * ��ȡ��Ŀ·���µ�webrootĿ¼
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator  + "webroot";
    // �ر�����
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    // ���չر�����
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
                //�ȴ�����
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                // ����Request����(Requestʵ�ִ���������)
                Request request = new Request(input);

                // ����Response����
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                request.parse();
                // �ر�socket
                socket.close();
                //�����ǰ��URI�Ƿ��ǹر�����
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
