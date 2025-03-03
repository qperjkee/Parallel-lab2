package Task3;

import java.util.ArrayList;
import java.util.List;

class Student {
    private final String name;
    private final List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public synchronized void addGrade(int grade) {
        grades.add(grade);
    }

    public synchronized double getAverageGrade() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public List<Integer> getGrades() {
        return grades;
    }
}
