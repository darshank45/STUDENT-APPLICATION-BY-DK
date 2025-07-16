package in.pentagon.studentapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.StudentappDao.connector.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDaoImp implements StudentappDao {
	private Connection con;
	public StudentDaoImp() { 
		this.con=Connector.requestconnection();
	}

	@Override
	 public boolean insertStudent(Student s) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT VALUES (0, ?, ?, ?, ?, ?, ?, SYSDATE())")) {
            ps.setString(1, s.getName());
            ps.setLong(2, s.getPhone());
            ps.setString(3, s.getMail());
            ps.setString(4, s.getBranch());
            ps.setString(5, s.getLoc());
            ps.setString(6, s.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE STUDENT SET NAME=?, PHONE=?, MAIL=?, BRANCH=?, LOCATION=?, PASSWORD=? WHERE ID=?")) {
            ps.setString(1, s.getName());
            ps.setLong(2, s.getPhone());
            ps.setString(3, s.getMail());
            ps.setString(4, s.getBranch());
            ps.setString(5, s.getLoc());
            ps.setString(6, s.getPassword());
            ps.setInt(7, s.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM STUDENT WHERE ID=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Student getStudent(String mail, String password) {
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?")) {
            ps.setString(1, mail);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToStudent(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudent(long phone, String mail) {
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?")) {
            ps.setLong(1, phone);
            ps.setString(2, mail);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToStudent(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Student> getStudent() {
        ArrayList<Student> list = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT WHERE ID!=1")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Student> getStudent(String name) {
        ArrayList<Student> list = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT WHERE NAME=?")) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setPhone(rs.getLong("phone"));
        s.setMail(rs.getString("mail"));
        s.setBranch(rs.getString("branch"));
        s.setLoc(rs.getString("location"));
        s.setPassword(rs.getString("password"));
        s.setDate(rs.getString("date"));
        return s;
    }
}
