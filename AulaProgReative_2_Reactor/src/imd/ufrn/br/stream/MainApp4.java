package imd.ufrn.br.stream;

import java.util.concurrent.SubmissionPublisher;
import reactor.core.publisher.Flux;
public class MainApp4 {
	public static void main(String[] args) {
		Flux<String> seq1 = Flux.just("Red", "Blue", "Yellow","Black");
		seq1.subscribe(); 

		seq1.subscribe(t -> System.out.println("consuming " + t));   

		seq1.subscribe(t -> System.out.println("consuming " + t),
		                e -> e.printStackTrace() ); 

		seq1.subscribe(t -> System.out.println("consuming " + t),
		                e -> e.printStackTrace(),
		                ()-> System.out.println("Finished")); 
		
	}
}
