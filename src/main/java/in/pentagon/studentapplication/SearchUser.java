package in.pentagon.studentapplication;

import java.io.IOException;
import java.util.ArrayList;

import in.pentagon.studentapp.DAO.StudentDaoImp;
import in.pentagon.studentapp.DAO.StudentappDao;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchUser")
public class SearchUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String searchKey = req.getParameter("search");

        StudentappDao sdao = new StudentDaoImp();
        ArrayList<Student> users = sdao.getStudent(searchKey);  // 🧠 You must have this method returning list

        if (users != null && !users.isEmpty()) {
            req.setAttribute("result", users);
        } else {
            req.setAttribute("error", "No user found with: " + searchKey);
        }

        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
        rd.forward(req, resp);
    }
}
