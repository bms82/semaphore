package bms.practice.semaphore.example;

import java.util.concurrent.Semaphore;

public class SimpleSemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, true);
        // Semaphore semaphore = new Semaphore(5, true); 여기서 true는 FIFO를 담보함
        for (int i = 0; i < 20; i++) {
            new Thread(new Worker(semaphore)).start();
        }

    }
}
