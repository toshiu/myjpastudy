package apl.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import apl.entity.City;
import apl.entity.Province;

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
	
	public City selectCityAndProvince(int cityId) {
		City res = null;
		
		try {
			em.getTransaction().begin();
			res = em.find(City.class, cityId);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return res;
	}
	
	public void deleteProvinceAndCity(int provinceId) {
		try {
			em.getTransaction().begin();
			Province province = em.find(Province.class, provinceId);
			em.remove(province);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
