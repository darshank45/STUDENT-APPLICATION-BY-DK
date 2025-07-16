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
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String mail = req.getParameter("mail");
        String password = req.getParameter("password");

        StudentappDao sdao = new StudentDaoImp();
        Student student = sdao.getStudent(mail, password); // ✅ Get real student data from DB

        HttpSession session = req.getSession(true);
        resp.setContentType("text/html");

        if (student != null) {
            // ✅ Set actual student object in session
            session.setAttribute("student", student);
            req.setAttribute("success", "Login Successfully!");
            RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
            rd.forward(req, resp);
        } else {
            // ❌ Login failed
            req.setAttribute("error", "Invalid credentials!");
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
        }
    }
}
