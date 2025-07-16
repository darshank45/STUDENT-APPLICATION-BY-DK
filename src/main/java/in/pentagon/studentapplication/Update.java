package in.pentagon.studentapplication;

import java.io.IOException;

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

@WebServlet("/update")
public class Update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // ✅ Safely fetch session
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("student") == null) {
            req.setAttribute("error", "Session expired! Please login again.");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            return;
        }

        // ✅ Student object from session
        Student s = (Student) session.getAttribute("student");

        // ✅ DAO instance
        StudentappDao sdao = new StudentDaoImp();

        try {
            // ✅ Update fields from form
            s.setName(req.getParameter("name"));
            s.setPhone(Long.parseLong(req.getParameter("phone")));
            s.setMail(req.getParameter("mail"));
            s.setBranch(req.getParameter("branch"));
            s.setLoc(req.getParameter("loc"));

            // ✅ Call update in DAO
            boolean updated = sdao.updateStudent(s);

            if (updated) {
                req.setAttribute("success", "Account updated successfully!");
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Update failed. Please try again.");
                req.getRequestDispatcher("update.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("error", "Invalid input: " + e.getMessage());
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        }
    }
}
