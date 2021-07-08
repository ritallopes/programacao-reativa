package imd.ufrn.br.stream;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class MainApp1 {

	public static void main(String[] args) {

		SubmissionPublisher<Event> publisher = new SubmissionPublisher();

		for (int i = 0; i < 5; i++) {

			Consumer consumer = new Consumer("Consumer " + i);

			publisher.subscribe(consumer);
		}

		Producer system1 = new Producer(publisher, "System 1");

		new Thread(system1).start();

		do {

			System.out.println("Publisher: MaximunLag:" + publisher.estimateMaximumLag());

			System.out.println("Publisher: Max Buffer Capacity: " +

					publisher.getMaxBufferCapacity());

			try {
				TimeUnit.SECONDS.sleep(10);
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		while ((publisher.estimateMaximumLag() > 0));

	}

}