package apl.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import apl.entity.Family;
import apl.entity.FamilyPK;

public class FamilyDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJPATest");
	EntityManager em = emf.createEntityManager();
	
	public boolean insert(Family family) {
		try {
			em.getTransaction().begin();
			em.persist(family);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}
	
	public Family findByPk(FamilyPK familyPk) {
		Family f = null;
		
		try {
			em.getTransaction().begin();
			f = em.find(Family.class, familyPk);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return f;
	}
}
