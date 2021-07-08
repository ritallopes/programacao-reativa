package imd.ufrn.br.fibonacci;
public class Fibonacci {
	public long fibo(long n) {
		long count = 0, a = 0, b = 1;
        while (count < n-1) {
            long sum = a + b;
            a = b;
            b = sum;
            count++;
        }
        return b;
    }
}
