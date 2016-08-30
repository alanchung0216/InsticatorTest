package com.insticator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator; 
 
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException; 
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.insticator.json.JSON_Employee;
import com.insticator.json.JSON_Read;
import com.insticator.json.JSON_Write;
import com.insticator.model.Contracter;
import com.insticator.model.Employee;
import com.insticator.model.Fulltime;
import com.insticator.model.Parttime;
import com.insticator.model.Intern;

/*
	this main program will do the followings
	
	1. create test employee data set in JSON format to "test.json"
		
	2. read the test data set via JSON reader from "test.json"
	3. use Spring framwork to inject employee and subclasses objects
		and fill up object data based on employee types 
		(employee,fulltime, partime, intern, contractor)
	4. set up Hibernate connection to postgres data base
		and map objects to one employee table which consists
		of employee and subclasses data
	5. do CRUD operations (CREATE, READ, UPDATE, DELETE)
	6. finally write existing employess with JSON format to "employees.json".
		
*/

public class EmployeeMain {
   public static SessionFactory factory; 
   public static void main(String[] args) {

	/*
	 *  1. create test employee data set in JSON format  
	 */
	   
	JSON_Write createJSON = new JSON_Write();
	createJSON.writeJSON();

	/*
	 *  2. read the test data set via JSON reader
	 */
	
	JSON_Read parseJSON = new JSON_Read();
	
	/*
	 *  3. use Spring framwork to inject employee and subclasses objects
	 *	   and fill up object data based on employee types 
	 *     (employee,fulltime, partime, intern, contractor) 
	 */
	
	ApplicationContext context = 
	       new ClassPathXmlApplicationContext("Beans.xml");
	
	Employee em = parseJSON.readJSON("emp");
	Employee obj1 = (Employee) context.getBean("Employee");

	obj1.setFirstName(em.getFirstName());
	obj1.setLastName(em.getLastName());
	
	Fulltime obj2 = (Fulltime) context.getBean("Fulltime");
	Fulltime ft = (Fulltime) parseJSON.readJSON("fulltime");
	
	obj2.setFirstName(ft.getFirstName());
	obj2.setLastName(ft.getLastName());
	obj2.setSalary(ft.getSalary());
	obj2.setVacation(ft.getVacation());
		
	Parttime obj3 = (Parttime) context.getBean("Parttime");
	Parttime pt = (Parttime) parseJSON.readJSON("parttime");
	
	obj3.setFirstName(pt.getFirstName());
	obj3.setLastName(pt.getLastName());
	obj3.setSalary(pt.getSalary());
	obj3.setWorkhours(pt.getWorkhours());

		
	Intern obj4 = (Intern) context.getBean("Intern");
	Intern it = (Intern) parseJSON.readJSON("intern");
	
	
	obj4.setFirstName(it.getFirstName());
	obj4.setLastName(it.getLastName());
	obj4.setWage(it.getWage());
		
	Contracter obj5 = (Contracter) context.getBean("Contracter");
	Contracter ct = (Contracter) parseJSON.readJSON("contracter");
	
	obj5.setFirstName(ct.getFirstName());
	obj5.setLastName(ct.getLastName());
	obj5.setWage(ct.getWage());
	obj5.setOvertimehours(ct.getOvertimehours());
	

	/*
		4. set up Hibernate connection to postgres data base
		and map objects to one employee table which consists
		of employee and subclasses data	
		see detail in hibernate.cfg.xml and Employee.hbm.xml
	*/
	
	try{
		   factory = new Configuration().configure().buildSessionFactory();
	}catch (Throwable ex) { 
		   System.err.println("Failed to create sessionFactory object." + ex);
		   throw new ExceptionInInitializerError(ex); 
	}
     
	/* 
	 * 5 - Create employee records in database 
	 */
		  
	EmployeeMain PE = new EmployeeMain();
	Integer empID1 = PE.addEmployee(obj1);
	Integer empID2 = PE.addEmployee(obj2);
	Integer empID3 = PE.addEmployee(obj3);
	Integer empID4 = PE.addEmployee(obj4);
	Integer empID5 = PE.addEmployee(obj5);

	/* 
	 * 5 - Read all the employees 
	 */
      
	PE.listEmployees();

	/* 
	 * 5 - Update employee's record 
	 */
	      
	System.out.println(" updated on empID   "+empID2);
	PE.updateEmployee(empID2, 90000);

	/* 
	 * 5 - Delete an employee from the database 
	 */
      
	PE.deleteEmployee(empID4);
	System.out.println(" deleted on empID "+empID4);

	/* 
	 * 6 - finally write existing employess to a file with JSON format.
	 */
      
	JSON_Employee empJSON = new JSON_Employee();
	empJSON.employeeJSON(PE.listEmployees());
      
   }
   
   /* CRUD Method - CREATE an employee in the database */
   
   public Integer addEmployee(Employee employee){   
   
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
   
   /* CRUD Method - READ all the employees */
   
   public List<Employee> listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      List<Employee> employees = new ArrayList<Employee>();
      try{
         tx = session.beginTransaction();
         employees = session.createQuery("FROM Employee").list(); 
         Iterator iterator = employees.iterator();
         while( iterator.hasNext()) {
            Employee employee = (Employee) iterator.next(); 
            System.out.printf("First Name: %s",employee.getFirstName()); 
            System.out.printf("  Last Name: %s%n",employee.getLastName()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employees;
   }
   
   /* CRUD Method - UPDATE salary for an employee */
   
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
   
   /* CRUD Method - DELETE an employee from the records */
   
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
