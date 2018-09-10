package apl.startup;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import apl.dao.StudentDao;
import apl.entity.Student;

public class StudentStartup {

	public static void main(String[] args) throws ParseException {
		StudentDao studentDao = new StudentDao();
		
//		Student s1 = new Student();
//		s1.setStudentId(1);
//		s1.setName("Duzhiyu");
//		s1.setSex("1");
//		s1.setAge((short)30);
//		s1.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1988-03-22"));
//		s1.setTelephone("18621805608");
//		s1.setAddress("Shanghai");
		
		Student s2 = new Student();
		s2.setStudentId(2);
		s2.setName("Duzhiyu");
		s2.setSex("1");
		s2.setAge((short)30);
		s2.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1988-03-22"));
		s2.setTelephone("18621805608");
		s2.setAddress("Shanghai");
//		
//		studentDao.insert(s1);
		
//		System.out.println(studentDao.findById(1).getName());
//		System.out.println(studentDao.findByQueryName().getName());
		
		Student sx = studentDao.findById(1);
		sx.setAge((short)29);
		studentDao.merge(sx);
		studentDao.merge(s2);
		
	}

}
