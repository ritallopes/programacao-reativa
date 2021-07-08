package imd.ufrn.br.stream;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

public class MySubscribe <T> implements Flow.Subscriber<T> {

private Flow.Subscription subscription;



@Override

public void onSubscribe(Subscription subscription) {

this.subscription = subscription;

subscription.request(1);

}

@Override

public void onNext(T item) {

System.out.println("Got:"+item);

subscription.request(1);

}

@Override

public void onError(Throwable throwable) { throwable.printStackTrace(); }

@Override

public void onComplete() { System.out.println("Done"); }

}