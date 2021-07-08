package imd.ufrn.br.stream;

import java.util.Random;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.TimeUnit;

import reactor.core.publisher.BaseSubscriber;

public class Consumer extends BaseSubscriber<String> {
	private String name;
	private Subscription subscription;
	public Consumer(String name) {
		this.name = name;
	}
	public void hookOnSubscribe(Subscription subscription) {
		this.subscription = subscription;
		request(1);
	}
	public void hookOnNext(String value) {
		System.out.println(name+":"+value);
		request(1);
	}
}
