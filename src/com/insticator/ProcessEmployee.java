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
   public static SessionFactory factory; 
   public static void main(String[] args) {
	   
	//JSON_Write createJSON = new JSON_Write();
	//createJSON.writeJSON();

	ApplicationContext context = 
	       new ClassPathXmlApplicationContext("Beans.xml");
	
	JSON_Read parseJSON = new JSON_Read();
	
	Employee em = parseJSON.readJSON("emp");
	Employee obj1 = (Employee) context.getBean("Employee");
	obj1.setFirstName(em.getFirstName());
	obj1.setLastName(em.getLastName());
	//System.out.println(" First name "+obj1.getFirstName());
	
	Fulltime obj2 = (Fulltime) context.getBean("Fulltime");
	Fulltime ft = (Fulltime) parseJSON.readJSON("fulltime");
	
	obj2.setFirstName(ft.getFirstName());
	obj2.setLastName(ft.getLastName());
	obj2.setSalary(ft.getSalary());
	obj2.setVacation(ft.getVacation());

	//System.out.println(" First name "+obj2.getFirstName());
		
	Parttime obj3 = (Parttime) context.getBean("Parttime");
	Parttime pt = (Parttime) parseJSON.readJSON("parttime");
	
	obj3.setFirstName(pt.getFirstName());
	obj3.setLastName(pt.getLastName());
	obj3.setSalary(pt.getSalary());
	obj3.setWorkhours(pt.getWorkhours());
		
	//System.out.println(" First name "+obj3.getFirstName());

		
	Intern obj4 = (Intern) context.getBean("Intern");
	Intern it = (Intern) parseJSON.readJSON("intern");
	
	obj4.setFirstName(it.getFirstName());
	obj4.setLastName(it.getLastName());
	obj4.setWage(it.getWage());
	
	//System.out.println(" First name "+obj4.getFirstName());
	
	
	Contracter obj5 = (Contracter) context.getBean("Contracter");
	Contracter ct = (Contracter) parseJSON.readJSON("contracter");
	
	obj5.setFirstName(ct.getFirstName());
	obj5.setLastName(ct.getLastName());
	obj5.setWage(ct.getWage());
	obj5.setOvertimehours(ct.getOvertimehours());
	
	//System.out.println(" First name "+obj5.getFirstName());
	
	
	   try{
		   factory = new Configuration().configure().buildSessionFactory();
	   }catch (Throwable ex) { 
		   System.err.println("Failed to create sessionFactory object." + ex);
		   throw new ExceptionInInitializerError(ex); 
	   }
     
	   ProcessEmployee PE = new ProcessEmployee();
      /* Add few employee records in database */
      Integer empID1 = PE.addEmployee(obj1);
      Integer empID2 = PE.addEmployee(obj2);
      Integer empID3 = PE.addEmployee(obj3);
      Integer empID4 = PE.addEmployee(obj4);
      Integer empID5 = PE.addEmployee(obj5);

      /* List down all the employees */
      PE.listEmployees();

      /* Update employee's records */
      System.out.println(" empID2 updated "+empID2);
      PE.updateEmployee(empID2, 90000);

      /* Delete an employee from the database */
      PE.deleteEmployee(empID4);
      System.out.println(" empID4  deleted "+empID4);

      /* List down new list of the employees */
      PE.listEmployees();
   }
   /* Method to CREATE an employee in the database */
   public Integer addEmployee(Employee employee){
	//public Integer addEmployee(String fname, String lname){	   
   
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
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
            System.out.println();
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
   public void updateEmployee(Integer EmployeeID, int pay ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                    (Employee)session.get(Employee.class, EmployeeID); 
         if (employee instanceof Fulltime){
        	 Fulltime ft = (Fulltime) employee;
        	 ft.setSalary(pay);
        	 session.update(ft);
         } else if (employee instanceof Parttime){
        	 Parttime pt = (Parttime) employee;
        	 pt.setSalary(pay);
        	 session.update(pt);
         } else if (employee instanceof Intern) {
        	 Intern it = (Intern) employee;
        	 it.setWage(pay);
        	 session.update(it);
         } else if (employee instanceof Contracter) {
        	 Contracter ct = (Contracter) employee;
        	 ct.setWage(pay);
        	 session.update(ct);
         } else {
        	 session.update(employee);
         } 
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
         if (employee instanceof Fulltime){
        	 Fulltime ft = (Fulltime) employee;
        	 session.delete(ft);
         } else if (employee instanceof Parttime){
        	 Parttime pt = (Parttime) employee;
        	 session.delete(pt);
         } else if (employee instanceof Intern) {
        	 Intern it = (Intern) employee;
        	 session.delete(it);
         } else if (employee instanceof Contracter) {
        	 Contracter ct = (Contracter) employee;
        	 session.delete(ct);
         } else {
        	 session.delete(employee);
         }          
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
