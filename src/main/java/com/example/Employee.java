package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee
{

    @Id
    int Id;
    String Name;
    int age;
    int salary;

    public void setId(int id)
    {
        this.Id=id;
    }

    public int getId()
    {
        return Id;
    }

    public void setName(String name){
        this.Name=name;
    }

    public String getName()
    {
        return Name;
    }

    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public int getSalary(){
        return salary;
    }



}