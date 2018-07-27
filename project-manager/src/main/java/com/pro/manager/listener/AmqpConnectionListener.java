package com.pro.manager.listener;

import com.rabbitmq.client.ShutdownSignalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.listener
 * @date: Created in 2018/7/23 16:48
 */
public class AmqpConnectionListener implements ConnectionListener {

    private static final Logger logger = LoggerFactory.getLogger(AmqpConnectionListener.class);

    /**
     * Called when a new connection is established.
     *
     * @param connection the connection.
     */
    @Override
    public void onCreate(Connection connection) {
        logger.info("connection is open-------------->:{}", connection.isOpen());
    }

    /**
     * Called when a connection is closed.
     *
     * @param connection the connection.
     * @see #onShutDown(ShutdownSignalException)
     */
    @Override
    public void onClose(Connection connection) {
        logger.info("--------------------> close");
    }

    /**
     * Called when a connection is force closed.
     *
     * @param signal the shut down signal.
     * @since 2.0
     */
    @Override
    public void onShutDown(ShutdownSignalException signal) {
        logger.info("shutDown --------------------> :{}", signal);
    }
}
