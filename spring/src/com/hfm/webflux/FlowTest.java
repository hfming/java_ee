package com.hfm.webflux;

//import java.util.concurrent.Flow;
//
//public class FlowTest {
//    public static void main(String[] args) {
//        // 被观察者
//        Flow.Publisher<String> publisher = subscriber -> {
//            subscriber.onNext("1"); // 1
//            subscriber.onNext("2");
//            subscriber.onError(new RuntimeException("出错")); // 2
//            //  subscriber.onComplete();
//        };
//
//        // 观察者
//        publisher.subscribe(new Flow.Subscriber<>() {
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                subscription.cancel();
//            }
//
//            @Override
//            public void onNext(String item) {
//                System.out.println(item);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("出错了");
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("publish complete");
//            }
//        });
//    }
//}
