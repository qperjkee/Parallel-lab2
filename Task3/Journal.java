package Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Journal {
    private final List<Student> group1;
    private final List<Student> group2;
    private final List<Student> group3;
    private final Lock lock = new ReentrantLock();

    public Journal() {
        group1 = createGroup("Group 1");
        group2 = createGroup("Group 2");
        group3 = createGroup("Group 3");
    }

    private List<Student> createGroup(String groupName) {
        List<Student> group = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            group.add(new Student(groupName + " Student " + i));
        }
        return group;
    }

    public List<Student> getGroup(int groupNumber) {
        switch (groupNumber) {
            case 1:
                return group1;
            case 2:
                return group2;
            case 3:
                return group3;
            default:
                throw new IllegalArgumentException("Invalid group number");
        }
    }

    public void assignGrades(int groupNumber, String grader, int week) {
        List<Student> group = getGroup(groupNumber);
        lock.lock();
        try {
            System.out.println("Week " + week + ": " + grader + " is assigning grades to " + "Group " + groupNumber);
            for (Student student : group) {
                int grade = new Random().nextInt(101);
                student.setGrade(grade);
                System.out.println(grader + " assigned " + grade + " to " + student.getName());
            }
            System.out.println(grader + " finished grading Group " + groupNumber + " for Week " + week);
        } finally {
            lock.unlock();
        }
    }

    public void printGrades(int week) {
        System.out.println("Grades for Week " + week + " - Group 1:");
        printGroupGrades(group1);
        System.out.println("Grades for Week " + week + " - Group 2:");
        printGroupGrades(group2);
        System.out.println("Grades for Week " + week + " - Group 3:");
        printGroupGrades(group3);
    }

    private void printGroupGrades(List<Student> group) {
        for (Student student : group) {
            System.out.println(student.getName() + ": " + student.getGrade());
        }
    }
}