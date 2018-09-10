package apl.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import apl.entity.City;

public class ProvinceCityDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJPATest");
	EntityManager em = emf.createEntityManager();
	
	public boolean insert(City city) {
		try {
			em.getTransaction().begin();
			em.persist(city);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}
}
