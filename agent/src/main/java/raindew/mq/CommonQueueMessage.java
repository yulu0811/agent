package raindew.mq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

/**
 * 通用消息队列存储对象，旨在通过路由分发模式实现一个消费者
 * 
 * @author yulu206836
 *
 */
public class CommonQueueMessage {

	/**
	 * 消息id
	 */
	private int messageId;

	/**
	 * 消息对象
	 */
	private Object message;

	/**
	 * 消息属性
	 */
	private Map<String, Object> attributes;

	/**
	 * 当前队列消息的处理方式是否为异步
	 */
	private boolean ansyc;

	public Object setAttributes(String key, Object value) {
		if (attributes == null) {
			attributes = new HashMap<String, Object>(4);
		}
		Assert.hasLength(key);
		Assert.notNull(value);
		return attributes.put(key, value);
	}

	public Object getAttritubes(String key) {
		if (attributes == null) {
			return null;
		}
		Assert.hasLength(key);
		return attributes.get(key);
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public boolean isAnsyc() {
		return ansyc;
	}

	public void setAnsyc(boolean ansyc) {
		this.ansyc = ansyc;
	}

}
