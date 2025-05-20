package com.example;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDB {

    Scanner scan=new Scanner(System.in);
    Employee emp=new Employee();

    public void addEmployee()
    {
        System.out.println("Enter Employee ID: ");
        emp.setId(scan.nextInt());

        System.out.println("Enter  Employee Name: ");
        emp.setName(scan.next());

        System.out.println("Enter Employee Age: ");
        emp.setAge(scan.nextInt());


        System.out.println("Enter Employee Salary: ");
        emp.setSalary(scan.nextInt());

        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            Transaction tx=session.beginTransaction();
            session.persist(emp);
            tx.commit();
            System.out.println("Employee added Successfully");
        }
        
    }

    public void viewEmployee()
    {
        System.out.println("Enter Employee Id: ");
        int id=scan.nextInt();

        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {

            emp=session.find(Employee.class,id);
            if(emp!=null){
                System.out.println("Employee ID: "+emp.getId());
                System.out.println("Employee Name: "+emp.getName());
                System.out.println("Employee Age: "+emp.getAge());
                System.out.println("Employee Salary: "+emp.getSalary());


            }
            else{
                System.out.println("Employee not Found");
            }

            
        } 
        


    }

    public void updateEmployeeDetails()
    {

        System.out.println("Enter Employee ID: ");
        int id=scan.nextInt();

         try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            emp=session.find(Employee.class,id);
            if(emp!=null){
                System.out.println("Enter  new  Name: ");
                emp.setName(scan.next());

                 System.out.println("Enter new Age: ");
                 emp.setAge(scan.nextInt());

                System.out.println("Enter new Salary: ");
                emp.setSalary(scan.nextInt());

                Transaction tx=session.beginTransaction();
                session.merge(emp);
                tx.commit();
                System.out.println("Update Successfull");
            }
            else{
                System.out.println("Employee not Found");

            }    
        } 
    }
    public void deleteEmployee()
    {
        System.out.println("Enter Employee ID: ");
        int id=scan.nextInt();

        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            emp=session.find(Employee.class,id);
             if(emp!=null){
               
                System.out.println("Employee Name: "+emp.getName());
                System.out.println("Employee Age: "+emp.getAge());
                System.out.println("Employee Salary: "+emp.getSalary());

                Transaction tx = session.beginTransaction();
                session.remove(emp);
                tx.commit();
                System.out.println("Employee deleted successfully!");


            }
            else{
                System.out.println("Employee not Found");
            }


        }

    }

}
