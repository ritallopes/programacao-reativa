package imd.ufrn.br.stream;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class MainApp2 {

	public static void main(String[] args) throws InterruptedException {
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
		MyFilterProcessor<String, String> filterProcessor = new MyFilterProcessor<>(s -> !s.equals("x"));
		MyTransformProcessor<String, Integer> transformProcessor =
				new MyTransformProcessor<>(s -> Integer.parseInt(s) + 5);
		MySubscribe<Integer> subscriber = new MySubscribe<>();
		publisher.subscribe(filterProcessor);
		filterProcessor.subscribe(transformProcessor);
		transformProcessor.subscribe(subscriber);
		System.out.println("Publishing itens");
		String[] items = { "100", "x", "200", "x", "300", "x" };
		Arrays.asList(items).stream().forEach(i -> publisher.submit(i));
		publisher.close();
		Thread.sleep(2000);
	}

}
