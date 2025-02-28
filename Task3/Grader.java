package Task3;

class Grader implements Runnable {
    private final Journal journal;
    private final int groupNumber;
    private final String name;
    private final int week;

    public Grader(Journal journal, int groupNumber, String name, int week) {
        this.journal = journal;
        this.groupNumber = groupNumber;
        this.name = name;
        this.week = week;
    }

    @Override
    public void run() {
        journal.assignGrades(groupNumber, name, week);
    }
}
