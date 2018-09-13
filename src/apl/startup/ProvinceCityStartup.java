package apl.startup;

import java.text.ParseException;

import apl.dao.ProvinceCityDao;
import apl.entity.City;
import apl.entity.Province;

public class ProvinceCityStartup {

	public static void main(String[] args) throws ParseException {
		
		ProvinceCityDao provinceCityDao = new ProvinceCityDao();
		
//		City city1 = new City();
//		city1.setCityId(1);
//		city1.setCityMan("Duzhiyu");
//		city1.setCityName("Wuhan");
//		
//		Province province1 = new Province();
//		province1.setProvinceId(101);
//		province1.setProvinceMan("Wangkun");
//		province1.setProvinceName("Hubei");
//		
//		city1.setProvince(province1);
//		
//		provinceCityDao.insert(city1);
		
		
//		System.out.println(provinceCityDao.selectCityAndProvince(1).getProvince().getProvinceMan());
		
//		provinceCityDao.deleteProvinceAndCity(101);
	}

}
