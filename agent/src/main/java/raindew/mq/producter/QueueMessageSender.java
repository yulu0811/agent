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
		 * �ӳٷ��ͣ���λ�����룬������ʾ�����ӳٷ���
		 */
		private long delay = -1;

		/**
		 * ���ʱ�䣬��λ�����룬������ʾ�����������
		 */
		private long period = -1;

		/**
		 * �ظ�������������ʾ���ظ�
		 */
		private int repeat = -1;

		/**
		 * CRON���ʽ�����CRON���ʽ��NULL������ʹ��CRON���ʽ
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
