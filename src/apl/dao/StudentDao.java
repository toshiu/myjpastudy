package apl.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import apl.entity.Student;

public class StudentDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJPATest");
	EntityManager em = emf.createEntityManager();
	
	public boolean insert(Student student) {
		try {
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}
	
	public Student findById(int id) {
		Student s = null;
		
		try {
			em.getTransaction().begin();
			s = em.find(Student.class, 1);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return s;
	}
	
	public Student findByQueryName() {
		Student s = null;
		
		try {
			em.getTransaction().begin();
			s = em.createNamedQuery("Student.findAll", Student.class).getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return s;
	}
	
	public boolean merge(Student student) {
		try {
			em.getTransaction().begin();
			em.merge(student);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}
}
