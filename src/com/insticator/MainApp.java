package com.insticator;

/*
Create a MVP version of Java application for employee management.
Doesn't have to be a very complex, but the code should be readable, 
extendable, and maintainable.

Looking for certain tasks done in each back-end technology.

Java:
- There are multiple types of employee, include but not limit to full-time, part-time, intern.
- They are paid by year or hour.
- Add other fields you think should exist.
- Create model classes for all the employees.
- Utilize a backend MVC framework, e.g. Spring, Play

Database:
- Create proper scheme(s) to store employee.
- Implement JPA/Hibernate database with employee models that can be stored and retrieved.
- Create Java function to store new employee, get existing employee, and edit employee.

JSON:
- Function store new employee(s) by reading a JSON file.
- Function to export existing employees to a JSON file.

Version Control:
- Use Git or SVN to manage your code, upload you code to GitHub and submit the link to your repository.

installed MySQL and below is the password
root@localhost: O_beR/zpi6oy

2016-08-27T18:31:20.017541Z 1 [Note] A temporary password is generated 
for root@localhost: O_beR/zpi6oy

If you lose this password, please consult the section How to Reset 
the Root Password in the MySQL reference manual.

*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("Beans.xml");

      Employee obj = (Employee) context.getBean("Employee");

      System.out.println("Your FirstName : " + obj.getFirstName());
   }
}
