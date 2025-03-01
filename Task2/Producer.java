package Task2;

import java.util.Random;

public class Producer<T> implements Runnable{
    private Drop<T> drop;
    private T[] data;
    private T endItem;

    public Producer(Drop<T> drop, T[] data, T endItem) {
        this.drop = drop;
        this.data = data;
        this.endItem = endItem;
    }

    public void run() {
        Random random = new Random();

        for (int i = 0; i < data.length; i++) {
            drop.put(data[i]);
            System.out.format("MESSAGE PRODUCED: %s%n", data[i]);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {}
        }
        drop.put(endItem);
    }
}
