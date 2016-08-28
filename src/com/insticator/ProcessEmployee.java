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

public class ProcessEmployee {
   private static SessionFactory factory; 
   public static void main(String[] args) {
 
	ApplicationContext context = 
	       new ClassPathXmlApplicationContext("Beans.xml");
	
	Employee obj = (Employee) context.getBean("Employee");
	
	System.out.println("Your FirstName : " + obj.getFirstName());
      
	   try{
		   factory = new Configuration().configure().buildSessionFactory();
	   }catch (Throwable ex) { 
		   System.err.println("Failed to create sessionFactory object." + ex);
		   throw new ExceptionInInitializerError(ex); 
	   }
     
	   ProcessEmployee PE = new ProcessEmployee();
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
	//public Integer addEmployee(String fname, String lname, int salary){	   
   
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
