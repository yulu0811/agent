package raindew.mq.producter;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ScheduledMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class QueueMessageSenderImpl implements QueueMessageSender {

	final static MessageProperty DEFAULT_PROPERTY = new MessageProperty();

	private JmsTemplate jmsTemplate;

	private TaskExecutor taskExcutor;

	public <T> void send(Destination destination, final T message) {
		final Serializable serializableMsg = (Serializable) message;
		// 发送主题消息到队列
		jmsTemplate.send(destination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session
						.createObjectMessage(serializableMsg);
				setProperty(objectMessage, DEFAULT_PROPERTY);
				return objectMessage;
			}
		});
	}

	private void setProperty(ObjectMessage message, MessageProperty property)
			throws JMSException {
		if (message != null && property != null) {
			if (StringUtils.isNotBlank(property.getCron())) {
				message.setStringProperty(ScheduledMessage.AMQ_SCHEDULED_CRON,
						property.getCron());
			}
			if (property.getPeriod() > 0) {
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD,
						property.getPeriod());
			}
			if (property.getDelay() > 0) {
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,
						property.getDelay());
			}
			if (property.getRepeat() > 0) {
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT,
						property.getRepeat());
			}
		}
	}

	public <T> void sendAnsyc(final Destination destination, final T message) {

		taskExcutor.execute(new Runnable() {

			public void run() {
				send(destination, message);
			}
		});

	}

	public <T, M> void send(Destination destination, M message,
			QueueMessageCreator<T> creator) {
		T queueMsg = creator.create(message);
		this.send(destination, queueMsg);
	}

	public <T, M> void sendAnsyc(final Destination destination,
			final M message, final QueueMessageCreator<T> creator) {

		taskExcutor.execute(new Runnable() {

			public void run() {
				send(destination, message, creator);
			}
		});

	}

	public <T> void send(Destination destination, T message,
			final MessageProperty property) {
		final Serializable serializableMsg = (Serializable) message;
		jmsTemplate.send(destination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMsg = session
						.createObjectMessage(serializableMsg);
				setProperty(objectMsg, property);
				return objectMsg;
			}
		});

	}

	public <T> void sendAnsyc(final Destination destination, final T message,
			final MessageProperty property) {

		taskExcutor.execute(new Runnable() {

			public void run() {
				send(destination, message, property);
			}
		});

	}

	public <T, M> void send(Destination destination, M message,
			QueueMessageCreator<T> creator, final MessageProperty property) {

		final Serializable serializableMsg = (Serializable) message;

		jmsTemplate.send(destination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session
						.createObjectMessage(serializableMsg);
				setProperty(objectMessage, property);
				return objectMessage;
			}
		});
	}

	public <T, M> void sendAnsyc(final Destination destination,
			final M message, final QueueMessageCreator<T> creator,
			final MessageProperty property) {

		taskExcutor.execute(new Runnable() {

			public void run() {
				send(destination, message, creator, property);
			}
		});
	}

}
