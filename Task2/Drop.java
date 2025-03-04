package Task2;

public class Drop <T> {
    private T message;
    private boolean empty = true;

    public synchronized T take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(T message) {
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}
