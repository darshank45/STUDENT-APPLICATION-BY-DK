<%@ page import="in.pentagon.studentapp.dto.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Student Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .success { text-align: center; color: green; }
    .error { text-align: center; color: red; }
  </style>
</head>
<body>
<%
  Student s = (Student) session.getAttribute("student");
  if (s == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Welcome <%= s.getName() %> 👋</a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="ResetPass.jsp">Reset Password</a></li>
        <li class="nav-item"><a class="nav-link" href="update.jsp">Update Data</a></li>
        <li class="nav-item">
          <form action="logout" method="post">
            <input type="submit" class="btn btn-danger" name="logout" value="Logout">
          </form>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Body -->
<div class="container mt-4">
  <h1 class="text-center mb-4">Dashboard</h1>

  <% String success = (String) request.getAttribute("success"); %>
  <% if (success != null) { %>
    <h3 class="success"><%= success %></h3>
  <% } %>

  <!-- Search -->
  <form action="searchUser" method="post" class="d-flex justify-content-center mb-4">
    <input class="form-control w-50 me-2" type="text" name="search" placeholder="Search by name or email" required>
    <button class="btn btn-outline-success" type="submit">Search</button>
  </form>

  <!-- Table -->
  <div class="row">
    <div class="col-md-12">
      <h3>Your Data</h3>
      <table class="table table-hover table-bordered">
        <thead class="table-dark">
          <tr>
            <th>ID</th><th>Name</th><th>Phone</th><th>Mail</th>
            <th>Branch</th><th>Location</th><th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getPhone() %></td>
            <td><%= s.getMail() %></td>
            <td><%= s.getBranch() %></td>
            <td><%= s.getLoc() %></td>
            <td>
              <form action="delete" method="post" onsubmit="return confirm('Are you sure you want to delete your account?')">
                <input type="hidden" name="id" value="<%= s.getId() %>">
                <input type="submit" class="btn btn-danger btn-sm" value="Delete">
              </form>
            </td>
          </tr>
        </tbody>
      </table>

      <%-- Search Results Section --%>
      <%
        ArrayList<Student> results = (ArrayList<Student>) request.getAttribute("result");
        if (results != null && !results.isEmpty()) {
      %>
        <h3 class="mt-5">Search Results</h3>
        <table class="table table-hover table-bordered">
          <thead class="table-secondary">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Phone</th>
              <th>Mail</th>
              <th>Branch</th>
              <th>Location</th>
            </tr>
          </thead>
          <tbody>
            <% for (Student stu : results) { %>
            <tr>
              <td><%= stu.getId() %></td>
              <td><%= stu.getName() %></td>
              <td><%= stu.getPhone() %></td>
              <td><%= stu.getMail() %></td>
              <td><%= stu.getBranch() %></td>
              <td><%= stu.getLoc() %></td>
            </tr>
            <% } %>
          </tbody>
        </table>
      <% } else if (request.getAttribute("result") != null) { %>
        <p class="text-center text-danger mt-4">No results found.</p>
      <% } %>

    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
