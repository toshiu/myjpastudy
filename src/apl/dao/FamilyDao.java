package apl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	public Family findByMan(String man) {
		Family f = null;
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select f from Family f where f.id.man = :man");
			q.setParameter("man", man);
			f = (Family) q.getResultList().get(0);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return f;
	}
	
	public List<Family> findDescList() {
		List<Family> fList = null;
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select f from Family f order by f.address desc NULLS FIRST");
			fList = (List<Family>) q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return fList;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>> findManAndWomanList() {
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select f.id.man, f.id.woman from Family f");
			List jpqlRes= q.getResultList();
			if (jpqlRes!=null){
				Iterator iterator = jpqlRes.iterator();
				while( iterator.hasNext() ){
					Object[] row = (Object[]) iterator.next();
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("man", row[0].toString());
					resMap.put("woman", row[1].toString());
					resList.add(resMap);
				}
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return resList;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>> findCityManList() {
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select f.id.man, f.id.woman, c.cityName from Family f left join City c on f.id.man = c.cityMan");
			List jpqlRes= q.getResultList();
			if (jpqlRes!=null){
				Iterator iterator = jpqlRes.iterator();
				while( iterator.hasNext() ){
					Object[] row = (Object[]) iterator.next();
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("man", row[0].toString());
					resMap.put("woman", row[1].toString());
					resMap.put("cityName", row[2] == null ? null : row[2].toString());
					resList.add(resMap);
				}
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return resList;
	}
	
}
