package com.pro.manager.listener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ShutdownSignalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ChannelListener;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.listener
 * @date: Created in 2018/7/23 17:10
 */
public class AmqpChannelListener implements ChannelListener {

    private static final Logger logger = LoggerFactory.getLogger(AmqpChannelListener.class);

    /**
     * Called when a new channel is created.
     *
     * @param channel       the channel.
     * @param transactional true if transactional.
     */
    @Override
    public void onCreate(Channel channel, boolean transactional) {
        logger.info("----------------> create channel");
    }

    /**
     * Called when the underlying RabbitMQ channel is closed for any
     * reason.
     *
     * @param signal the shut down signal.
     */
    @Override
    public void onShutDown(ShutdownSignalException signal) {
        logger.error("shutDown exception---------------->:{}", signal);
    }
}
