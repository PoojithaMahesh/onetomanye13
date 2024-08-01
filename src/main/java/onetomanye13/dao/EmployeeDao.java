package onetomanye13.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanye13.dto.Company;
import onetomanye13.dto.Employee;

public class EmployeeDao {
public void saveEmployeee(int companyId,Employee employee) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager  entityManager=entityManagerFactory.createEntityManager();
	Company dbCompany=entityManager.find(Company.class, companyId);
	if(dbCompany!=null) {
//		that company exist so you can join to that company
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
//		dbCompany is the company that he wants to join
//		what i want to do now
//		i want add this employee to the dbCompany's list of Employee
//		first im going to tak dbCompany.getEmployee
//		it will give all the employees who is working in that company
//		to that list you need to add the new employee
		List<Employee> employees=dbCompany.getEmployees();
//		to this im going add new employee
		employees.add(employee);
//		now i want to reset this employees to the company
		dbCompany.setEmployees(employees);
		entityTransaction.commit();
	}
}

public void updateEmployee(int employeeId,Employee employee) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager  entityManager=entityManagerFactory.createEntityManager();
	Employee dbEmployee=entityManager.find(Employee.class, employeeId);
	if(dbEmployee!=null) {
//		employee is present
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		employee.setId(employeeId);
		entityManager.merge(employee);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry Id is not present");
	}
}
public void findEmployee(int employeeId) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager  entityManager=entityManagerFactory.createEntityManager();
	Employee dbEmployee=entityManager.find(Employee.class, employeeId);
	if(dbEmployee!=null) {
//		employee is present
		System.out.println(dbEmployee);
	}else {
		System.out.println("Sorry Id is not present");
	}
}
public void deleteEmployee(int employeeId) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager  entityManager=entityManagerFactory.createEntityManager();
	Employee dbEmployee=entityManager.find(Employee.class, employeeId);
	if(dbEmployee!=null) {
//		employee is present
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(dbEmployee);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry Id is not present");
	}
}















}
