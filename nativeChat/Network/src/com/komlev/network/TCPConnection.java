package com.komlev.network;

import java.io.*;
import java.net.Socket;

public class TCPConnection {
    private final TCPConnectionListener eventListener;
    private final Socket socket;
    private final Thread rxThread;
    private final BufferedReader input;
    private final BufferedWriter output;

    public TCPConnection(TCPConnectionListener eventListener, String ipAddress, int port) throws IOException {
        this(eventListener, new Socket(ipAddress, port));
    }

    public TCPConnection(TCPConnectionListener eventListener, Socket socket) throws IOException {
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.eventListener = eventListener;

        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventListener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted()) {
                        eventListener.onReciveString(TCPConnection.this, input.readLine());
                    }
                } catch (IOException e) {
                    eventListener.onExeption(TCPConnection.this, e);
                } finally {
                    eventListener.onDisconnect(TCPConnection.this);
                }
            }
        });
        rxThread.start();
    }

    public synchronized void sendMessage(String value) {
        try {
            output.write(value + "\r\n");
            output.flush();
        } catch (IOException e) {
            eventListener.onExeption(TCPConnection.this, e);
            disconnect();
        }

    }

    public synchronized void disconnect() {
        rxThread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onExeption(TCPConnection.this, e);
        }
    }

    @Override
    public String toString() {
        return "TCPConnection: " + socket.getInetAddress() + ": " + socket.getPort();
    }
}
