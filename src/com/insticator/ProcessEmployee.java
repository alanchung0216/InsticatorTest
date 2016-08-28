package com.insticator;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException; 
import org.hibernate.cfg.Configuration;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration SYSTEM 
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
   <session-factory>
   <property name="hibernate.dialect">
      org.hibernate.dialect.MySQLDialect
   </property>
   <property name="hibernate.connection.driver_class">
      com.mysql.jdbc.Driver
   </property>

   <!-- Assume test is the database name -->
   <property name="hibernate.connection.url">
      jdbc:mysql://localhost/test
   </property>
   <property name="hibernate.connection.username">
      root
   </property>
   <property name="hibernate.connection.password">
      root123
   </property>

   <!-- List of XML mapping files -->
   <mapping resource="Employee.hbm.xml"/>

</session-factory>
</hibernate-configuration>

PostgreSQL	org.hibernate.dialect.PostgreSQLDialect

PostgreSQL	org.hibernate.dialect.PostgreSQLDialect

createdb -h localhost -p 5432 -U postgres testdb
password ******
H*12

[alanc@Alans-MacBook-Pro] ~ $ /Library/PostgreSQL/9.2/scripts/runpsql.sh; exit
Server [localhost]:                     
Database [postgres]: 
Port [5432]: 
Username [postgres]: 
Password for user postgres: 
psql (9.2.18)
Type "help" for help.

postgres=# \d

// this is MySQL command
create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);

CREATE TABLE EMPLOYEE (
   ID INT PRIMARY KEY     NOT NULL,
   FIRST_NAME TEXT    NOT NULL,
   LAST_NAME  TEXT    NOT NULL,
   SALARY     INT  	NOT NULL
);

CREATE TABLE COMPANY(
   ID INT PRIMARY KEY     NOT NULL,
   NAME           TEXT    NOT NULL,
   AGE            INT     NOT NULL,
   ADDRESS        CHAR(50),
   SALARY         REAL
);
 */
public class ProcessEmployee {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ProcessEmployee PE = new ProcessEmployee();


 
	ApplicationContext context = 
	       new ClassPathXmlApplicationContext("Beans.xml");
	
	Employee obj = (Employee) context.getBean("Employee");
	
	System.out.println("Your FirstName : " + obj.getFirstName());

      
      /* Add few employee records in database */
      Integer empID1 = PE.addEmployee(obj);
      //Integer empID1 = PE.addEmployee("Zara", "Ali", 1000);
      //Integer empID2 = PE.addEmployee("Daisy", "Das", 5000);
      //Integer empID3 = PE.addEmployee("John", "Paul", 10000);

      /* List down all the employees */
      PE.listEmployees();

      /* Update employee's records */
//      PE.updateEmployee(empID1, 90000);

      /* Delete an employee from the database */
//      PE.deleteEmployee(empID2);

      /* List down new list of the employees */
      PE.listEmployees();
   }
   /* Method to CREATE an employee in the database */
   public Integer addEmployee(Employee employee){
	   //public Integer addEmployee(String fname, String lname, int salary)	   
   
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
         //Employee employee = new Employee(fname, lname, salary);
         employeeID = (Integer) session.save(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employeeID;
   }
   /* Method to  READ all the employees */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
            Employee employee = (Employee) iterator.next(); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE salary for an employee */
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                    (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
		 session.update(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE an employee from the records */
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                   (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
