package in.pentagon.studentapplication;


import java.io.IOException;

import in.pentagon.studentapp.DAO.StudentDaoImp;
import in.pentagon.studentapp.DAO.StudentappDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        StudentappDao dao = new StudentDaoImp();
        boolean deleted = dao.deleteStudent(id);

        if (deleted) {
            req.setAttribute("success", "Student deleted successfully!");
        } else {
            req.setAttribute("error", "Failed to delete student!");
        }

        // Forward back to dashboard or searchResult.jsp
        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
        rd.forward(req, resp);
    }
}
