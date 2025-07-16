package in.pentagon.studentapp.DAO;

import java.util.ArrayList;

import in.pentagon.studentapp.dto.Student;

public interface StudentappDao {
	 boolean insertStudent(Student s);
	    boolean updateStudent(Student s);
	    boolean deleteStudent(int id);
	    Student getStudent(String mail, String password);
	    Student getStudent(long phone, String mail);
	    ArrayList<Student> getStudent();
	    ArrayList<Student> getStudent(String name);
	}
