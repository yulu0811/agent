package raindew.mq.consumer;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class QueueMessageConsumer implements Runnable {

	/**
	 * ��Ϣ����Ŀ�ĵ�
	 */
	private Destination queueDestination;

	/**
	 * jmsģ��
	 */
	private JmsTemplate jmsTemplate;

	/**
	 * ���ճ�ʱʱ��
	 */
	private long receiveTimeout = 30000;

	/**
	 * �Ƿ���������
	 */
	private boolean running = true;

	/**
	 * ��ǰ�������߳�
	 */
	private Thread currentConsumerThread;

	/**
	 * �������߳�����
	 */
	private String consumerThreadName;

	/**
	 * worker�̳߳أ�null��ʾ�����߳�ִ�У���֮��worker�߳���ִ��
	 */
	private ThreadPoolTaskExecutor workerThreadPool;

	public void run() {
		// TODO Auto-generated method stub

	}

}
