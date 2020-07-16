package com.komlev.server;

import com.komlev.network.TCPConnection;
import com.komlev.network.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ChatServer implements TCPConnectionListener {
    public static void main(String[] args) {
        new ChatServer();
    }

    private final List<TCPConnection> connections = new ArrayList<>();

    private ChatServer() {
        System.out.println("Server running...");
        try (ServerSocket serverSocket = new ServerSocket(25674)) {
            while (true) {
                try {
                    TCPConnection connection = new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.out.println("TCPConnection exception " + e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllClients("Client connected " + tcpConnection);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllClients("Client disconnected " + tcpConnection);
    }

    @Override
    public synchronized void onReciveString(TCPConnection tcpConnection, String message) {
        sendToAllClients(message);

    }

    @Override
    public synchronized void onExeption(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exeption: " + e);
    }

    private void sendToAllClients(String value) {
        System.out.println(value);
        final int count = connections.size();
        for (int i = 0; i < count; i++) {
            connections.get(i).sendMessage(value);
        }
    }

}
