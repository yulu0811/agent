package raindew.mq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

/**
 * ͨ����Ϣ���д洢����ּ��ͨ��·�ɷַ�ģʽʵ��һ��������
 * 
 * @author yulu206836
 *
 */
public class CommonQueueMessage {

	/**
	 * ��Ϣid
	 */
	private int messageId;

	/**
	 * ��Ϣ����
	 */
	private Object message;

	/**
	 * ��Ϣ����
	 */
	private Map<String, Object> attributes;

	/**
	 * ��ǰ������Ϣ�Ĵ���ʽ�Ƿ�Ϊ�첽
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
