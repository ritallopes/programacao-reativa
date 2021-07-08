package imd.ufrn.br.stream;

import java.util.Optional;
import java.util.concurrent.SubmissionPublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink.OverflowStrategy;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
public class MainApp6 {
	public static void main(String[] args) {
		
		Mono<String> noData = Mono.empty(); 
		Mono<String> data = Mono.just("foo");
		Mono<String> stream6 = Mono.justOrEmpty(null);
		Mono<String> stream8 = Mono.fromCallable( () -> { return "Teste";} );

			
		for (int i = 0; i < 5; i++) {
			Consumer consumer = new Consumer("Consumer " + i);
			stream8.subscribe(consumer);
		}
		
	}
}
