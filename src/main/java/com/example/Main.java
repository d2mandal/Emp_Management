package com.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

       EmployeeDB emp=new EmployeeDB();
        Scanner scan=new Scanner(System.in);
        int choice;


        do{
            System.out.println("***Choose Operation***");
            System.out.println("1.Add Employee");
            System.out.println("2.View Employee");
            System.out.println("3.Update Employee Details");
            System.out.println("4.Delete Employee");
            System.out.println("5.Exit");
            System.out.print("Enter your Choice: ");
            choice=scan.nextInt();

           // Enhanced switch expression introduced in Java 14+ (preview in Java 12/13).
            //It uses arrow syntax (->), executes only one case (no fall-through), and does not require break.
            switch(choice){
                case 1->emp.addEmployee(); 
                case 2-> emp.viewEmployee();
                case 3-> emp.updateEmployeeDetails();
                case 4-> emp.deleteEmployee();
                default-> System.out.println("Exit");

            }

        }
        while(choice!=5);
        scan.close();
    }
}