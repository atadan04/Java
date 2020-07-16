package com.komlev.network;

public interface TCPConnectionListener {
    void onConnectionReady(TCPConnection tcpConnection);
    void onDisconnect(TCPConnection tcpConnection);
    void onReciveString(TCPConnection tcpConnection,String message);
    void onExeption(TCPConnection tcpConnection,Exception e);
}
