package Task4.Unsynchronized;

public class SymbolPrinter implements Runnable{
    private char symbol;
    private final int amount;

    public SymbolPrinter(char symbol, int amount) {
        this.symbol = symbol;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            System.out.print(symbol);
        }
    }
}
