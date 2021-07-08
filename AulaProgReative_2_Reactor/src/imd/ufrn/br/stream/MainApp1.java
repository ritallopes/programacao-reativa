package imd.ufrn.br.stream;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

import reactor.core.publisher.Flux;
public class MainApp1 {
	public static void main(String[] args) {
		Flux<Integer> seq1 = Flux.fromStream(IntStream.range(1,100).boxed());
		ConsumerInt consumer = new ConsumerInt("Consumer 1");
		seq1.subscribe(consumer);
	}
}
