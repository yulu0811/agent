package raindew.mq.producter;

import javax.jms.Destination;

public interface QueueMessageSender {

	<T> void send(Destination destination, T message);

	<T> void sendAnsyc(Destination destination, T message);

	<T, M> void send(Destination destination, M message,
			QueueMessageCreator<T> creator);

	<T, M> void sendAnsyc(Destination destination, M message,
			QueueMessageCreator<T> creator);

	<T> void send(Destination destination, T message, MessageProperty property);

	<T> void sendAnsyc(Destination destination, T message,
			MessageProperty property);

	<T, M> void send(Destination destination, M message,
			QueueMessageCreator<T> creator, MessageProperty property);

	<T, M> void sendAnsyc(Destination destination, M message,
			QueueMessageCreator<T> creator, MessageProperty property);

	interface QueueMessageCreator<T> {

		<M> T create(M message);
	}

	final static class MessageProperty {

		/**
		 * 延迟发送，单位：毫秒，负数表示不做延迟发送
		 */
		private long delay = -1;

		/**
		 * 间隔时间，单位：毫秒，负数表示不做间隔发送
		 */
		private long period = -1;

		/**
		 * 重复次数，负数表示不重复
		 */
		private int repeat = -1;

		/**
		 * CRON表达式，如果CRON表达式非NULL，优先使用CRON表达式
		 */
		private String cron;

		public long getDelay() {
			return delay;
		}

		public void setDelay(long delay) {
			this.delay = delay;
		}

		public long getPeriod() {
			return period;
		}

		public void setPeriod(long period) {
			this.period = period;
		}

		public int getRepeat() {
			return repeat;
		}

		public void setRepeat(int repeat) {
			this.repeat = repeat;
		}

		public String getCron() {
			return cron;
		}

		public void setCron(String cron) {
			this.cron = cron;
		}

	}
}
