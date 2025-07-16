package in.pentagon.studentapplication;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.DAO.StudentDaoImp;
import in.pentagon.studentapp.DAO.StudentappDao;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signUp")
public class Signup extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Student s=new Student();
 StudentappDao sdao= new StudentDaoImp();
 PrintWriter out=resp.getWriter();
 s.setName(req.getParameter("name"));
 s.setPhone(Long.parseLong(req.getParameter("phone")));
 s.setMail(req.getParameter("mail"));
 s.setBranch(req.getParameter("branch"));
 s.setLoc(req.getParameter(("loc")));
 if(req.getParameter("password").equals(req.getParameter("confirm"))) {
	 s.setPassword(req.getParameter("password"));
	 boolean res=sdao.insertStudent(s);
	 if(res) {
		 req.setAttribute("success","Account Created Sucesfully");
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		rd.forward(req, resp);//out.println("<h1> data saved successfully</h1>");
	 }else {
		 req.setAttribute("error","Account not  Created ");
			RequestDispatcher rd=req.getRequestDispatcher("signUp.jsp");
			rd.forward(req, resp);
	 }
 }else {
	 req.setAttribute("error","password mis match");
		RequestDispatcher rd=req.getRequestDispatcher("signUp.jsp");
		rd.forward(req, resp); }
}
}