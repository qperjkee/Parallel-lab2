package Task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Journal journal = new Journal();
        int weeks = 2;

        for (int week = 1; week <= weeks; week++) {
            System.out.println("\n=== Week " + week + " ===");

            Thread lecturer = new Thread(new Grader(journal, 1, "Lecturer", week));
            Thread assistant1 = new Thread(new Grader(journal, 2, "Assistant 1", week));
            Thread assistant2 = new Thread(new Grader(journal, 3, "Assistant 3", week));
            Thread assistant3 = new Thread(new Grader(journal, 1, "Assistant 2", week));

            lecturer.start();
            assistant1.start();
            assistant2.start();
            assistant3.start();

            lecturer.join();
            assistant1.join();
            assistant2.join();
            assistant3.join();

            journal.printGrades(week);
        }
    }
}
