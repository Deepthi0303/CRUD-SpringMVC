package spring_mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import spring_mvc.dto.Student_credential;

@Component
public class To_Database {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public String insert(Student_credential d1) {
		entityTransaction.begin();
		entityManager.persist(d1);
		entityTransaction.commit();
		return "Data Inserted";
	}
	
	public Object fetch(String email) {
		Student_credential database=entityManager.find(Student_credential.class,email);
		if(database==null) {
			return "no data found";
		}else {
			return database;
		}
	}
	
	public String delete(String email) {
		Student_credential credential=entityManager.find(Student_credential.class, email);
		if(credential==null) {
			return "no data found";
		}else {
			entityTransaction.begin();
			entityManager.remove(credential);
			entityTransaction.commit();
			return "data deleted";
		}
	}
	
	public Object findAll() {
		Query q = entityManager.createQuery("Select v from  Student_credential v");
		List<Student_credential> dto=q.getResultList();
		if(dto.isEmpty()) {
			return "no data found";
		}else {
			return dto;
		}
	}
	
	public String deleteAll() {
      Query q=entityManager.createQuery("Select a from Student_credential a");
      List<Student_credential> dto = q.getResultList();
	  if(dto.isEmpty()) {
		  return "Nothing to Delete";
	  }else {
		  for(Student_credential s:dto) {
				entityTransaction.begin();
				entityManager.remove(s);
				entityTransaction.commit();
			}
		  return "deleted all";
	  }
	  
	}
	
	public void update(Student_credential credential) {
		entityTransaction.begin();
		entityManager.merge(credential);
		entityTransaction.commit();
		
	}
}
