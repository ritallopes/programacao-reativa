package imd.ufrn.br.stream;

import java.util.Random;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.TimeUnit;

import reactor.core.publisher.BaseSubscriber;

public class ConsumerLong extends BaseSubscriber<Long> {
	private String name;
	private Subscription subscription;
	private int contador = 0;
	public ConsumerLong(String name) {
		this.name = name;
	}
	public void hookOnSubscribe(Subscription subscription) {
		this.subscription = subscription;
		request(1);
	}
	public void hookOnNext(Long value) {
		System.out.println(name+":"+value);
		contador++;
		if (contador>49)
			cancel();
		
	}
}
