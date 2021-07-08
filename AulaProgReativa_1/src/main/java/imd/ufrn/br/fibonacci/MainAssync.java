package imd.ufrn.br.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainAssync {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(new FibonacciCallable(50));
		executor.submit(new FibonacciCallable(10));
		executor.submit(new FibonacciCallable(5));
	}
}
