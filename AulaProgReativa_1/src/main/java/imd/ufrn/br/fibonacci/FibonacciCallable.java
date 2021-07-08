package imd.ufrn.br.fibonacci;
import java.util.concurrent.Callable;
public class FibonacciCallable implements Callable<Long> {
	private long numinit;
	FibonacciCallable(long i) {
		numinit = i;
	}
	public Long call() {
		long count = 0, a = 0, b = 1;
	        while (count < numinit-1) {
	            long sum = a + b;
	            a = b;
	            b = sum;
	            count++;
	        }
	    System.out.print("(" + numinit + "):" + b + "\t");
		return b;
	}
}
