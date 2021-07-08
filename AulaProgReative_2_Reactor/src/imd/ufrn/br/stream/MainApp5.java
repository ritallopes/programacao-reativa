package imd.ufrn.br.stream;

import java.util.concurrent.SubmissionPublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink.OverflowStrategy;
import reactor.core.scheduler.Schedulers;
public class MainApp5 {
	public static void main(String[] args) {
		
		Flux<String> fluxAsyncBackp = Flux.create(emitter -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("Publishing = " + i);
				emitter.next("Number:"+i);
			}
			emitter.complete();
		}, OverflowStrategy.DROP);
		
		
		for (int i = 0; i < 5; i++) {
			Consumer consumer = new Consumer("Consumer " + i);
			fluxAsyncBackp.subscribe(consumer);
		}
		
	}
}
