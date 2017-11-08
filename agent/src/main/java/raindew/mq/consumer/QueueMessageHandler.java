package raindew.mq.consumer;

public interface QueueMessageHandler<T> {

	/**
	 * 队列消息处理器
	 * 
	 * @param message
	 * @throws Exception
	 * @throws Throwable
	 */
	void handler(T message) throws Exception, Throwable;
}
