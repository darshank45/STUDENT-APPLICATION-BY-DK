package in.pentagon.studentapp.console;

import java.util.Scanner;

import in.pentagon.studentapp.DAO.StudentDaoImp;
import in.pentagon.studentapp.DAO.StudentappDao;
import in.pentagon.studentapp.dto.Student;

public class Update {
  public static void update(Student s) {
		        Scanner sc = new Scanner(System.in);
		        StudentappDao sdao= new StudentDaoImp();
		        int choice;
		        System.out.println("Enter the field to be updated");
		        do {
		            System.out.println("1. NAME\n2. PHONE\n3. MAIL ID\n4. BRANCH\n5. LOCATION\n6. BACK");
		            choice = sc.nextInt();
		            switch (choice) {
		                case 1: s.setName(sc.next()); break;
		                case 2: s.setPhone(sc.nextLong()); break;
		                case 3: s.setMail(sc.next()); break;
		                case 4: s.setBranch(sc.next()); break;
		                case 5: s.setLoc(sc.next()); break;
		                case 6: break;
		                default: System.out.println("Invalid choice!"); break;
		            }
		            boolean res = sdao.updateStudent(s);
		            System.out.println(res ? "Account updated!" : "Failed to update");
		        } while (choice != 6);
		    }
		
  
	
}

