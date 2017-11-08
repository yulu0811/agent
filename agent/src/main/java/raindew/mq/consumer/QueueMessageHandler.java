package raindew.mq.consumer;

public interface QueueMessageHandler<T> {

	/**
	 * ������Ϣ������
	 * 
	 * @param message
	 * @throws Exception
	 * @throws Throwable
	 */
	void handler(T message) throws Exception, Throwable;
}
