package imd.ufrn.br.stream;

import java.util.Random;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.TimeUnit;

public class Consumer implements Subscriber<Event> {

	private String name;

	private Subscription subscription;

	public Consumer(String name) {
		this.name = name;
	}

	@Override

	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
		System.out.println("Subscription OK");
	}

	@Override

	public void onNext(Event event) {
		System.out
				.println("An event has arrived: " + event.getSource() + ": " + event.getDate() + ": " + event.getMsg());
		this.subscription.request(1);
		processEvent(event);
	}

	@Override

	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("No more events");
	}

	private void processEvent(Event event) {
		Random random = new Random();
		int number = random.nextInt(3);
		try {
			TimeUnit.SECONDS.sleep(number);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}