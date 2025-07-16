package in.pentagon.studentapp.console;

import java.util.Scanner;
import java.util.ArrayList;

import in.pentagon.studentapp.DAO.StudentDaoImp;
import in.pentagon.studentapp.DAO.StudentappDao;
import in.pentagon.studentapp.dto.Student;

public class Login {

	public static void login() {
        Scanner sc = new Scanner(System.in);
        StudentappDao sdao= new StudentDaoImp();

        System.out.println("Enter the mail ID:");
        String mail = sc.next();
        System.out.println("Enter the password:");
        String pass = sc.next();

        Student s = sdao.getStudent(mail, pass);
        if (s != null) {
            System.out.println("Logged in successfully, Welcome " + s.getName());
            int choice;
            do {
                System.out.println("1. View\n2. Update\n3. Reset Password\n4. Search user\n5. Main Menu");
                if (s.getId() == 1) {
                    System.out.println("6. View All\n7. Delete User");
                }
                choice = sc.nextInt();
                switch (choice) {
                     case 1:
                        System.out.println("--------------------------");
                        System.out.println("ID: " + s.getId());
                        System.out.println("Name: " + s.getName());
                        System.out.println("Phone: " + s.getPhone());
                        System.out.println("Mail: " + s.getMail());
                        System.out.println("Branch: " + s.getBranch());
                        System.out.println("Location: " + s.getLoc());
                        System.out.println("--------------------------");
                        break;
                    case 2: Update.update(s); break;
                    case 3: Password.forgot(); break;
                    case 4:
                        System.out.println("Enter user name:");
                        for (Student s2 : sdao.getStudent(sc.next())) {
                            System.out.println("Id:" + s2.getId());
                            System.out.println("Name:" + s2.getName());
                            System.out.println("Branch:" + s2.getBranch());
                        }
                        break;
                    case 5: break;
                    case 6:
                        for (Student s1 : sdao.getStudent()) {
                            System.out.println("--------------------------");
                            System.out.println("ID: " + s1.getId());
                            System.out.println("Name: " + s1.getName());
                            System.out.println("Phone: " + s1.getPhone());
                            System.out.println("Mail: " + s1.getMail());
                            System.out.println("Branch: " + s1.getBranch());
                            System.out.println("Location: " + s1.getLoc());
                            System.out.println("--------------------------");
                        }
                        break;
                    case 7:
                        System.out.println("Enter student ID to delete:");
                        boolean res = sdao.deleteStudent(sc.nextInt());
                        System.out.println(res ? "Student deleted successfully." : "Failed to delete student.");
                        break;
                    default: System.out.println("Invalid choice!");
                }
            } while (choice != 5);
        } else {
            System.out.println("Failed to login!");
        }
    }
}
