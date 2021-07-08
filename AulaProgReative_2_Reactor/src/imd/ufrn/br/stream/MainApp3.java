package imd.ufrn.br.stream;

import java.util.concurrent.SubmissionPublisher;
import reactor.core.publisher.Flux;
public class MainApp3 {
	public static void main(String[] args) {
		
		Flux<String> flux = Flux.generate(
			    () -> 0, 
			    (state, sink) -> {
			      sink.next("3 x " + state + " = " + 3*state);
			      if (state == 10) sink.complete(); 
			      return state + 1; 
			    });
		
		for (int i = 0; i < 5; i++) {
			Consumer consumer = new Consumer("Consumer " + i);
			flux.subscribe(consumer);
		}
	}
}
