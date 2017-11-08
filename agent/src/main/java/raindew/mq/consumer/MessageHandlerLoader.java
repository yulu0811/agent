package raindew.mq.consumer;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import raindew.mq.CommonQueueMessage;

public class MessageHandlerLoader implements
		QueueMessageHandler<CommonQueueMessage>, ApplicationContextAware {

	private ApplicationContext context;

	private Map<Integer, HandlerInvoker> handlerInvokerMap;

	public void handler(CommonQueueMessage message) throws Exception, Throwable {
		// TODO Auto-generated method stub

	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}

}
