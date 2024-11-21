package bms.practice.semaphore.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Semaphore;

@RestController
@RequestMapping("/limit")
public class LimitController {

    private final Semaphore semaphore = new Semaphore(2);

    @GetMapping
    public String getMethod() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " Semaphore acquired and running");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + " Semaphore terminated");
            return "Get request received by " + Thread.currentThread().getName();

        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error with Semaphore Request";
        } finally {
            semaphore.release();
        }
    }

}
