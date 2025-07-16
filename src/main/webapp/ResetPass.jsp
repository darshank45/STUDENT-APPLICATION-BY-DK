<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Reset Password</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
  <style>
    .failure { color: red; }
    .success { color: green; }
  </style>
</head>
<body bgcolor='#add8e6'>
  <%
    Student s = (Student) session.getAttribute("student");
    if (s == null) {
      response.sendRedirect("Login.jsp");
      return;
    }
  %>

  <div class="container mt-4">
    <h1 class="text-center">Reset Password</h1>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
      <h3 class="failure text-center"><%= error %></h3>
    <% } %>

    <% String success = (String) request.getAttribute("success"); %>
    <% if (success != null) { %>
      <h3 class="success text-center"><%= success %></h3>
    <% } %>

    <form action="resetPassword" method="post" class="w-50 mx-auto">
      <div class="mb-3">
        <label>Phone:</label>
        <input type="tel" name="phone" class="form-control" value="<%= s.getPhone() %>" required>
      </div>
      <div class="mb-3">
        <label>Mail:</label>
        <input type="email" name="mail" class="form-control" value="<%= s.getMail() %>" required>
      </div>
      <div class="mb-3">
        <label>New Password:</label>
        <input type="password" name="password" class="form-control" required>
      </div>
      <div class="mb-3">
        <label>Confirm Password:</label>
        <input type="password" name="confirm" class="form-control" required>
      </div>
      <div class="text-center">
        <button type="submit" class="btn btn-success">Reset Password</button>
        <a href="dashboard.jsp" class="btn btn-secondary">Back</a>
      </div>
    </form>
  </div>
</body>
</html>
