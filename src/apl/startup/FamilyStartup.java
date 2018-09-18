package apl.startup;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import apl.dao.FamilyDao;
import apl.entity.Family;
import apl.entity.FamilyPK;

public class FamilyStartup {

	public static void main(String[] args) throws ParseException {
		FamilyDao familyDao = new FamilyDao();
		
//		FamilyPK fpk1 = new FamilyPK();
//		fpk1.setMan("Wangjianping");
//		fpk1.setWoman("Zhanghuafang");
//		
//		Family f1 = new Family();
//		f1.setId(fpk1);
//		f1.setAddress(null);
//		
//		familyDao.insert(f1);
//		
//		Family x = familyDao.findByPk(fpk1);
//		System.out.println(x.getId().getMan());
//		System.out.println(x.getAddress());
		
//		Family x = familyDao.findByMan("Duzhiyu");
//		System.out.println(x.getAddress());
		
//		java.util.List<Family> x = familyDao.findDescList();
//		System.out.println(x.get(0).getAddress());
//		System.out.println(x.get(x.size() - 1).getAddress());
		
//		List<Map<String, Object>> x = familyDao.findManAndWomanList();
//		for (Map<String, Object> m : x) {
//			System.out.println(m);
//		}
		
		List<Map<String, Object>> x = familyDao.findCityManList();
		for (Map<String, Object> m : x) {
			System.out.println(m);
		}
	}

}
