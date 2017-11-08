package raindew.mq.consumer;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class QueueMessageConsumer implements Runnable {

	/**
	 * 消息队列目的地
	 */
	private Destination queueDestination;

	/**
	 * jms模板
	 */
	private JmsTemplate jmsTemplate;

	/**
	 * 接收超时时间
	 */
	private long receiveTimeout = 30000;

	/**
	 * 是否正在运行
	 */
	private boolean running = true;

	/**
	 * 当前消费者线程
	 */
	private Thread currentConsumerThread;

	/**
	 * 消费者线程名称
	 */
	private String consumerThreadName;

	/**
	 * worker线程池，null表示在主线程执行，反之在worker线程中执行
	 */
	private ThreadPoolTaskExecutor workerThreadPool;

	public void run() {
		// TODO Auto-generated method stub

	}

}
