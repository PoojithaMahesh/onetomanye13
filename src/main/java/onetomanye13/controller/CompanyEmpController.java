package onetomanye13.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanye13.dao.CompanyDao;
import onetomanye13.dao.EmployeeDao;
import onetomanye13.dto.Company;
import onetomanye13.dto.Employee;

public class CompanyEmpController {
public static void main(String[] args) {
	
//	Company  company=new Company();
//	company.setId(2);
//	company.setName("INfosys");
//	company.setGst("info@123");
//	CompanyDao companyDao=new CompanyDao();
//	companyDao.saveCompany(company);
	
	Employee employee=new Employee();
	employee.setId(5);
	employee.setName("bharath");
	employee.setAddress("Bang");
	
	EmployeeDao employeeDao=new EmployeeDao();
	employeeDao.saveEmployeee(2, employee);
	
	
	
}
}
