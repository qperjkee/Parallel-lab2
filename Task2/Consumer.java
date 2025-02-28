package Task2;

import java.util.Random;

public class Consumer<T> implements Runnable{
    private Drop<T> drop;
    private T endItem;

    public Consumer(Drop<T> drop, T endItem) {
        this.drop = drop;
        this.endItem = endItem;
    }

    public void run() {
        Random random = new Random();
        for (T item = drop.take();
             !item.equals(endItem);
             item = drop.take()) {

            System.out.format("MESSAGE RECEIVED: %s%n", item);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {}
        }
    }
}
