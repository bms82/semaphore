package bms.practice.semaphore.example;

import java.util.concurrent.Semaphore;

public class Worker implements Runnable {
    private final Semaphore semaphore;
    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
            // semaphore.acquire(2); 이 경우는 한 번에 2개의 허가를 획득하게 됨.
            System.out.println(Thread.currentThread().getName() + " is Running");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " is Terminating");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // 허가는 항상 끝나면 반납해야 다른 쓰레드 사용 가능.
        }
    }
}
