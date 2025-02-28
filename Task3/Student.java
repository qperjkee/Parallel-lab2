package Task3;

class Student {
    private final String name;
    private int grade;

    public Student(String name) {
        this.name = name;
        this.grade = 0;
    }

    public String getName() {
        return name;
    }

    public synchronized void setGrade(int grade) {
        this.grade = grade;
    }

    public synchronized int getGrade() {
        return grade;
    }
}
