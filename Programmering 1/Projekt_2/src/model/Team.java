package model;

import java.util.Arrays;

public class Team {
    private String name;
    private String room;
    private int studentCount;
    private Student[] students = new Student[32];
    private final char[] correctAnswers = {'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B'};

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.studentCount = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("The team is filled, no more spaces!");
        }
    }

    public int getStudentCount() {
        return studentCount;
    }


    public Student[] getStudents() {
        Student[] temp = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            temp[i] = students[i];
        }
        return temp;
    }


    public void removeStudent(String name) {
        int i = 0;
        boolean found = false;
        while (!found && i < studentCount) {
            if (students[i] != null && name.equalsIgnoreCase(students[i].getName())) {
                studentCount--;
                for (int j = i; j < studentCount; j++) {
                    students[j] = students[j + 1];
                    found = true;
                }
            }
            i++;
        }

    }

    public double getAvgTeamGrade() {
        double gradeSum = 0;
        int gradeCount = 0;
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < students[i].getGrades().length; j++) {
                gradeSum += students[i].getGrades()[j];
                gradeCount++;
            }
        }
        return gradeSum / gradeCount;
    }

    public Student[] highScoreStudents(double minAverage) {
        Student[] temp = new Student[studentCount];
        int count = 0;

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getAvgGrade() >= minAverage && students[i].getActive()) {
                temp[count] = students[i];
                count++;
            }
        }
        temp = Arrays.copyOf(temp, count);
        return temp;
    }

    public String[] printTeam() {
        String[] temp = new String[studentCount];

        for (int i = 0; i < studentCount; i++) {
            temp[i] = String.format("\nName %10s      Grade average %5.2f      Correct answers %5d  ",
                    getStudents()[i].getName(), getStudents()[i].getAvgGrade(), getStudents()[i].correctAnswers(correctAnswers));

        }
        return temp;
    }


    public int[] checkCorrectAnswers() {
        int[] difficulty = new int[correctAnswers.length];
        for (int i = 0; i < studentCount; i++) {
            getStudents()[i].generateAnswers();
        }

        for (int i = 0; i < correctAnswers.length; i++) {
            for (int j = 0; j < studentCount; j++) {
                if (students[j].getTestAnswers()[i] == correctAnswers[i]) {
                    difficulty[i]++;
                }
            }
        }
        return difficulty;
    }
}

