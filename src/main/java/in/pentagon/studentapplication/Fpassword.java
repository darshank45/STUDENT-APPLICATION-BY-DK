package in.pentagon.studentapplication;

	import java.io.IOException;
	import java.io.PrintWriter;

	import in.pentagon.studentapp.DAO.StudentDaoImp;
	import in.pentagon.studentapp.DAO.StudentappDao;
	import in.pentagon.studentapp.dto.Student;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/resetPassword")
	public class Fpassword extends HttpServlet {

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        String phoneStr = req.getParameter("phone");
	        String mail = req.getParameter("mail");
	        String newPassword = req.getParameter("newPassword");
	        String confirmPassword = req.getParameter("confirmPassword");

	        resp.setContentType("text/html");
	        PrintWriter out = resp.getWriter();

	        try {
	            long phone = Long.parseLong(phoneStr);

	            StudentappDao sdao = new StudentDaoImp();
	            Student s = sdao.getStudent(phone, mail);

	            if (s != null) {
	                if (newPassword.equals(confirmPassword)) {
	                    s.setPassword(newPassword);
	                    boolean result = sdao.updateStudent(s);

	                    if (result) {
	                        out.println("<h2 style='color:green;'>Password updated successfully!</h2>");
	                        out.println("<a href='Login.jsp'>Go to Login</a>");
	                    } else {
	                        out.println("<h2 style='color:red;'>Failed to update password. Try again later.</h2>");
	                    }
	                } else {
	                    out.println("<h2 style='color:red;'>Password mismatch. Please re-enter.</h2>");
	                    out.println("<a href='forgotPassword.jsp'>Try Again</a>");
	                }
	            } else {
	                out.println("<h2 style='color:red;'>No user found with given phone and mail.</h2>");
	                out.println("<a href='forgotPassword.jsp'>Try Again</a>");
	            }

	        } catch (NumberFormatException e) {
	            out.println("<h2 style='color:red;'>Invalid phone number format!</h2>");
	        } catch (Exception e) {
	            e.printStackTrace();
	            out.println("<h2 style='color:red;'>Server Error! Please try again later.</h2>");
	        }
	    }
	}




	































