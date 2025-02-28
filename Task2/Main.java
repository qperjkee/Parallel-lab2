package Task2;

public class Main {
    public static void main(String[] args) {
        int length = 5000;

        Drop<Integer> drop = new Drop<>();
        Integer[] data = new Integer[length];

        for (int i = 0; i < length; i++){
            data[i] = i;
        }
        Integer endItem = -1;

        (new Thread(new Producer<>(drop, data, endItem))).start();
        (new Thread(new Consumer<>(drop, endItem))).start();
    }
}
