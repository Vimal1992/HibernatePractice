package com.vimal.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.annotationfactory.AnnotationFactory;
import org.hibernate.cfg.Configuration;

import com.vimal.entity.Department;
import com.vimal.entity.Employee;

public class FetchData {
	public static void main(String[] args) {
		Configuration config=new AnnotationFactory().create(null);
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		   SessionFactory sessionFactory = configuration.buildSessionFactory();
		   SessionFactory sessionFactory = (SessionFactory) configuration.addAnnotatedClass(com.vimal.entity.Employee.class)
				   .addAnnotatedClass(com.vimal.entity.Department.class);
		   
		   
		   
		   Session session=sessionFactory.openSession();
	       Transaction t= session.beginTransaction();
	        
	        List<Employee> empList=new ArrayList<Employee>();
	        Department dep=new Department();
	        dep.setDepName("HR");
	        dep.setDepLocation("PUNE");
	        Employee emp1=new Employee();
	        emp1.setEmpName("Ramesh");
	        emp1.setDepartment(dep);
	        Employee emp2=new Employee();
	        emp2.setEmpName("Rahul");
	        emp2.setDepartment(dep);
	        empList.add(emp1);
	        empList.add(emp2);
	        session.save(emp1);
	        session.save(emp2);
	        System.out.println("Your save is successful");
	        t.commit();
	        
	        dep.setEmployee(empList);
	        
	        
	        
	        
	        
	        
	        
	        

	}
	
	
	
	 
}



