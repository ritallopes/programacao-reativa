package imd.ufrn.br.stream;

import java.util.concurrent.SubmissionPublisher;
import reactor.core.publisher.Flux;
public class MainApp {
	public static void main(String[] args) {
		Flux<String> seq1 = Flux.just("Red", "Blue", "Yellow","Black");
		for (int i = 0; i < 5; i++) {
			Consumer consumer = new Consumer("Consumer " + i);
			seq1.subscribe(consumer);
		}
	}
}
