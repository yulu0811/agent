package raindew.mq.consumer;

import java.lang.reflect.Method;

/**
 * ��Ϣ������
 * 
 * @author yulu206836
 *
 */
public class HandlerInvoker {

	/**
	 * ��������
	 */
	private Object handler;

	/**
	 * ����
	 */
	private Method method;

	/**
	 * ��Ϣid
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
