package raindew.mq.consumer;

import java.lang.reflect.Method;

/**
 * 消息处理器
 * 
 * @author yulu206836
 *
 */
public class HandlerInvoker {

	/**
	 * 处理器类
	 */
	private Object handler;

	/**
	 * 方法
	 */
	private Method method;

	/**
	 * 消息id
	 */
	private int messageId;

	public Object getHandler() {
		return handler;
	}

	public void setHandler(Object handler) {
		this.handler = handler;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

}
