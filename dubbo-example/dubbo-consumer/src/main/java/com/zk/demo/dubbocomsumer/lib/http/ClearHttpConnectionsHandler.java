package com.zk.demo.dubbocomsumer.lib.http;

import org.apache.http.conn.HttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 失效链接清除
 */
public class ClearHttpConnectionsHandler extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(ClearHttpConnectionsHandler.class);

    private final HttpClientConnectionManager clientConnectionManager;

    private volatile boolean shutdown;

    public ClearHttpConnectionsHandler(HttpClientConnectionManager clientConnectionManager) {
        this.clientConnectionManager = clientConnectionManager;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    //关闭失效连接
                    clientConnectionManager.closeExpiredConnections();
                }
            }
        } catch (InterruptedException e) {
            logger.error("清除失效连接异常！{}-{}", Thread.currentThread().getName(), e);
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notify();
        }
    }
}
