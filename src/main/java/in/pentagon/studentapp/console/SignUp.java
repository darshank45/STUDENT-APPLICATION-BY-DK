package in.pentagon.studentapp.console;


	import java.util.Scanner;

import in.pentagon.studentapp.DAO.StudentDaoImp;
import in.pentagon.studentapp.DAO.StudentappDao;
import in.pentagon.studentapp.dto.Student;

	public class SignUp {

		public static void signup() {
			Scanner sc=new Scanner(System.in);
			Student s=new Student();
			 StudentappDao sdao= new StudentDaoImp();

			
			System.out.println("Enter the Name: ");
			s.setName(sc.next());
			
			System.out.println("Enter the Phone number:");
			s.setPhone(sc.nextLong());
			
			System.out.println("Enter the Mail Id:");
			s.setMail(sc.next());
			
			System.out.println("Enter the Branch:");
			s.setBranch(sc.next());
			
			System.out.println("Enter the Location:");
			s.setLoc(sc.next());
			
			System.out.println("Enter the Password:");
			String password=sc.next();
			
			System.out.println("Enter the confirm Password:");
			String conpassword=sc.next();
			
			if(password.equals(conpassword)) {
				s.setPassword(conpassword);
			
				 boolean succuss =sdao.insertStudent(s);
		 
		 if(succuss==true) {
			 System.out.println("signup succussfully");
		 }
		 else {
			 System.out.println("signup failed...try again");
		 }
			}
			else {
				System.out.println("Password is miss matching check password");
			}
		}
	   }