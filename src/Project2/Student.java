package Project2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abd Al-Massih
 */
public class Student {

    String studentName;
    private int studentTotalMark = 0;
    private int mathMark = 0;
    int physicsMark = 0;
    int chemistryMark = 0;
    int natScienceMark = 0;
    int arabicMark = 0;
    int englishMark = 0;
    int historyMark = 0;
    int geographyMark = 0;

    public int getTotalMark() {
        return this.studentTotalMark;

    }

    public Student(String studentName, int studentTotalMark) {
        this.studentName = studentName;
        this.studentTotalMark = studentTotalMark;

    }

    public Student() {

    }

    
    public static void main(String[] args) {
       // System.out.println(Integer.parseInt(8));
    }
}
