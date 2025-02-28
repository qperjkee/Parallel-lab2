package Task4.Synchronized;

public class SymbolPrinter implements Runnable{
    private char symbol;
    private final int amount;
    private final int myTurn;
    private static final Object lock = new Object();
    private static int turn = 1;

    public SymbolPrinter(char symbol, int amount, int myTurn) {
        this.symbol = symbol;
        this.amount = amount;
        this.myTurn = myTurn;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            synchronized (lock) {
                while (turn != myTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(symbol);

                turn = (myTurn % 3) + 1;

                lock.notifyAll();
            }
        }
    }
}
