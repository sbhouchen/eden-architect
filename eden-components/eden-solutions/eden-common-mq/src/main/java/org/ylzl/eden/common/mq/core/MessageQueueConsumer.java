package org.ylzl.eden.common.mq.core;

import org.ylzl.eden.common.mq.consumer.Acknowledgement;
import org.ylzl.eden.common.mq.model.Message;

import java.util.List;

/**
 * 消息队列消费者
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public interface MessageQueueConsumer {

	/**
	 * 消费消息
	 *
	 * @param messages
	 */
	void consume(List<Message> messages, Acknowledgement ack);
}
