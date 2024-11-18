package model;

import java.util.Arrays;
import java.util.Random;

public class Student {
    private String name;
    private boolean active = false;
    private int[] grades;
    private char[] testAnswers = new char[10];
    private final char[] correctAnswers = {'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B'};


    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public String toString() {
        return name;
    }

    public int getHighestGrade() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public double getAvgGrade() {
        double gradeSum = 0;
        for (int i = 0; i < grades.length; i++) {
            gradeSum += grades[i];
        }
        return gradeSum / grades.length;
    }

    public void generateAnswers() {
        Random random = new Random();
        char[] options = {'A', 'B', 'C', 'D'};

        for (int i = 0; i < testAnswers.length; i++) {
            testAnswers[i] = options[random.nextInt(options.length)];
        }
    }

    public char[] getTestAnswers() {
        return testAnswers;
    }

    public int correctAnswers(char[] correct) {
        int correctCount = 0;

        for (int i = 0; i < testAnswers.length; i++) {
            if (testAnswers[i] == correct[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public void printStudent(Student student) {

        System.out.println("Name of student: " + student.getName() + "(" + student.getActive() + ")");
        System.out.println(student.getName() + "'s grades: " + Arrays.toString(student.getGrades()));
        System.out.println(student.getName() + "'s average grade is: " + student.getAvgGrade());
        System.out.println(student.getName() + "'s test answers: " + Arrays.toString(student.getTestAnswers()));
        System.out.println(student.getName() + "'s number of correct answers: " + student.correctAnswers(correctAnswers));
        ;
    }

}
