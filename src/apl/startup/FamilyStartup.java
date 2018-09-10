package apl.startup;

import java.text.ParseException;

import apl.dao.FamilyDao;
import apl.entity.Family;
import apl.entity.FamilyPK;

public class FamilyStartup {

	public static void main(String[] args) throws ParseException {
		FamilyDao familyDao = new FamilyDao();
		
		FamilyPK fpk1 = new FamilyPK();
		fpk1.setMan("Duzhiyu");
		fpk1.setWoman("Wangkun");
		
		Family f1 = new Family();
		f1.setId(fpk1);
		f1.setAddress("Shanghai");
		
//		familyDao.insert(f1);
		
		Family x = familyDao.findByPk(fpk1);
		System.out.println(x.getId().getMan());
		System.out.println(x.getAddress());
	}

}
