package per.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@Service
public class AsyncService {


    //多线程计数器
    public static AtomicInteger count = new AtomicInteger(0);


    /**
     * 20个人过河，10条船，每个人随机给点钱，统计总共多少钱
     */
    @Async
    public void atomicadd() {


        log.info("异步线程开始");

        // 要执行总次数
        int clientTotal = 20;
        // 同时并发执行的线程数
        final int threadTotal = 10;


        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        log.info("count end:{}", count.get());


    }


    private static void add() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = new Random().nextInt(10);

        log.info(i + " | "+Thread.currentThread().getName() + " | " + count.addAndGet(i));

        // count.getAndIncrement();

    }


}
