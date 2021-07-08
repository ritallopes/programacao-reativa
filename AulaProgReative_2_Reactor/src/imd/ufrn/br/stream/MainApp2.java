package imd.ufrn.br.stream;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;
public class MainApp2 {
	public static void main(String[] args) {
		
		Flux<Long> seq1 = Flux.generate(
		        () -> Tuples.<Long, Long>of(0L, 1L),
		        (state, sink) -> {
		            sink.next(state.getT1());
		            System.out.println("generated "+state.getT1());
		            return Tuples.of(state.getT2(), state.getT1() + state.getT2());
		        });
		
		
		//seq1.take(50).subscribe(t -> {
		 //   System.out.println("consuming "+t);
		  // 	});
		
		ConsumerLong consumer = new ConsumerLong("Consumer 1");
		seq1.subscribe(consumer);
	}
}
