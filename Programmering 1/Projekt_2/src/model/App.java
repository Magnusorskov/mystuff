package model;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Student s1 = new Student("Magnus",true, new int[] {3,4,5,6});
        Student s2 = new Student("Simon",true,new int[] {4,5,6});
        Student s3 = new Student("Patrick",true,new int[] {9,3,5});
        Student s4 = new Student("Jonas",true,new int[] {12,10,7});
        Student s5 = new Student("William",true,new int[] {4,3,2});
        Student s6 = new Student("Margrethe",true,new int[]{12,12,12});
        Team t1 = new Team("Hold1",("Lokale 100"));
        Team t2 = new Team("Hold2","Lokale 6000");

        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);
        t2.addStudent(s4);
        t2.addStudent(s5);
        t2.addStudent(s6);
        t2.getStudents();
        
        System.out.println("*********");
        System.out.println(Arrays.toString(t2.getStudents()));
        System.out.println("*********");
        System.out.println(t2.getStudentCount());
        t2.removeStudent("");
        System.out.println(Arrays.toString(t2.getStudents()));
        System.out.println("*********");
        System.out.println(t2.getStudentCount());
        System.out.println(s1.getHighestGrade());
        System.out.printf("%.2f%n",s1.getAvgGrade());
        System.out.println(t1.getAvgTeamGrade());

        System.out.println(Arrays.toString(t2.highScoreStudents(10)));

        for (int i = 0; i < t2.printTeam().length; i++) {
            System.out.print((t2.printTeam()[i]));
        }
        System.out.println(Arrays.toString(t2.checkCorrectAnswers()));
    }
}
