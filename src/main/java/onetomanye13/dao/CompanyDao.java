package onetomanye13.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanye13.dto.Company;

public class CompanyDao {

	public void saveCompany(Company company) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void updateCompany(int id,Company company) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
//			company is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			company.setId(id);
			company.setEmployees(dbCompany.getEmployees());
			entityManager.merge(company);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	public void findCompany(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
//			company is present
			System.out.println(dbCompany);
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	public void deleteCompany(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
//			company is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	
	
	
}
