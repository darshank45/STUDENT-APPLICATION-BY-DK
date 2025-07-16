package in.pentagon.studentapp.console;

import java.util.Scanner;

import in.pentagon.studentapp.DAO.StudentDaoImp;
import in.pentagon.studentapp.DAO.StudentappDao;
import in.pentagon.studentapp.dto.Student;

public class Password {

	  public static void forgot() {
	        Scanner sc = new Scanner(System.in);
	        StudentappDao sdao= new StudentDaoImp();

	        System.out.println("Enter the Phone number:");
	        long phone = sc.nextLong();
	        System.out.println("Enter the mail ID:");
	        String mail = sc.next();

	        Student s = sdao.getStudent(phone, mail);
	        if (s != null) {
	            System.out.println("Set a new Password:");
	            String password = sc.next();
	            System.out.println("Confirm the new password:");
	            String confirm = sc.next();

	            if (password.equals(confirm)) {
	                s.setPassword(password);
	                boolean res = sdao.updateStudent(s);
	                System.out.println(res ? "Password updated!" : "Failed to update the password!");
	            } else {
	                System.out.println("Password mismatch");
	            }
	        } else {
	            System.out.println("Student not found!");
	        }
	    }
	}
