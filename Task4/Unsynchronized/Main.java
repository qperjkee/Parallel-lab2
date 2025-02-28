package Task4.Unsynchronized;

public class Main {
    final static int SYMBOLS_IN_LINE = 10;
        public static void main(String[] args) {
        for (int i = 0; i < 90; i++) {
        Thread thread1 = new Thread(new SymbolPrinter('|', SYMBOLS_IN_LINE));
        Thread thread2 = new Thread(new SymbolPrinter('\\', SYMBOLS_IN_LINE));
        Thread thread3 = new Thread(new SymbolPrinter('/', SYMBOLS_IN_LINE));

        thread1.start();
        thread2.start();
        thread3.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}