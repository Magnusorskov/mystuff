package model;

import java.util.Arrays;
import java.util.Scanner;

public class MenuApp {
    private static Scanner scan = new Scanner(System.in);
    private static Team[] teams = new Team[10];
    private static int teamCount = 0;

    public static void main(String[] args) {


        int choice = 1;
        while (choice != 6) {
            System.out.println(printMenu());
            choice = scan.nextInt();
            if (choice == 1) {
                choice1();

            } else if (choice == 2) {
                choice2();

            } else if (choice == 3) {
                choice3();

            } else if (choice == 4) {
                choice4();

            } else if (choice == 5) {
                choice5();
            }
        }
        System.out.println("Goodbye!");
    }


    private static String printMenu() {
        return "\nMENU" + "\n1: Create a team" + "\n2: Create a student" + "\n3: Show one student's info and results" +
                "\n4: Show one team's info and results" + "\n5: Show info and results for all teams " + "\n6: Exit program";
    }

    private static void choice1() {
        System.out.println("Team name and room: ");
        Team team = new Team(scan.next(), scan.next());
        System.out.println("--> Team created with name and room set to " + team.getName() + " and " + team.getRoom());
        teams[teamCount] = team;
        teamCount++;
    }

    private static void choice2() {
        boolean findTeamName = true;
        while (findTeamName) {
            System.out.println("Name of student's team");
            String studentTeam = scan.next();
            for (int i = 0; i < teamCount; i++) {
                if (teams[i].getName().equals(studentTeam)) {
                    System.out.println("Student's name and activity status (true/false): ");
                    String studentName = scan.next();
                    boolean isActive = scan.nextBoolean();

                    System.out.println("Student's number of grades: ");
                    int gradeCount = scan.nextInt();
                    int[] grades = new int[gradeCount];

                    System.out.println("Student's " + gradeCount + " grades: ");
                    for (int j = 0; j < gradeCount; j++) {
                        grades[j] = scan.nextInt();
                    }

                    Student student = new Student(studentName, isActive, grades);
                    teams[i].addStudent(student);
                    findTeamName = false;
                    System.out.println("--> Student " + student.getName() + "(" + student.getActive() + ")" +
                            " with grades " + Arrays.toString(student.getGrades()) + " created in team " + studentTeam);

                }

            }
            if (findTeamName) {
                System.out.println("Invalid team name, type a new one or type exit to go back to menu: ");
            }
        }
    }

    private static void choice3() {
        boolean findStudent = true;
        int i;

        while (findStudent) {
            System.out.println("What student would you like info on? ");
            String studentName = scan.next();
            i = 0;
            while (i < teamCount) {
                for (int j = 0; j < teams[i].getStudentCount(); j++) {
                    if (studentName.equalsIgnoreCase(teams[i].getStudents()[j].getName())) {
                        teams[i].getStudents()[j].generateAnswers();
                        teams[i].getStudents()[j].printStudent(teams[i].getStudents()[j]);
                        findStudent = false;
                    }

                }
                i++;
            }
            if (findStudent) {
                System.out.println("No student found");
            }
        }
    }

    private static void choice4() {
        boolean findTeam = true;
        int i;

        while (findTeam) {
            System.out.println("What team would you like info on? ");
            String teamName = scan.next();
            i = 0;
            while (i < teamCount) {
                if (teamName.equalsIgnoreCase(teams[i].getName())) {
                    System.out.println("\n--> Team info for team with name: " + teams[i].getName());
                    System.out.println("Average team grade: " + teams[i].getAvgTeamGrade());
                    for (int j = 0; j < teams[i].getStudentCount(); j++) {
                        System.out.print((teams[i].printTeam()[j]));
                    }
                    findTeam = false;
                }
                i++;
            }
            if (findTeam) {
                System.out.println("No team found");
            }
        }
    }

    private static void choice5() {
        for (int i = 0; i < teamCount; i++) {
            System.out.println("--> Team info for team with name: " + teams[i].getName());
            System.out.println("Average team grade: " + teams[i].getAvgTeamGrade());
            for (int j = 0; j < teams[i].getStudentCount(); j++) {
                System.out.print((teams[i].printTeam()[j]));
            }
        }
    }
}

