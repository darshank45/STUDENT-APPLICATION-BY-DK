<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Update Account</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
  <style>
    .error { color: red; }
    .success { color: green; }
  </style>
</head>
<body bgcolor="#e9f5f5">
<%
  Student s = (Student) session.getAttribute("student");
  if (s == null) {
    response.sendRedirect("Login.jsp");
    return;
  }
%>

<div class="container mt-5">
  <h2 class="text-center">Update Your Details</h2>

  <% String error = (String) request.getAttribute("error"); %>
  <% if (error != null) { %>
    <h5 class="text-center error"><%= error %></h5>
  <% } %>

  <% String success = (String) request.getAttribute("success"); %>
  <% if (success != null) { %>
    <h5 class="text-center success"><%= success %></h5>
  <% } %>

  <form action="Update" method="post" class="w-50 mx-auto">
    <input type="hidden" name="id" value="<%= s.getId() %>">

    <div class="mb-3">
      <label for="name">Name</label>
      <input type="text" name="name" class="form-control" value="<%= s.getName() %>" required>
    </div>

    <div class="mb-3">
      <label for="phone">Phone</label>
      <input type="tel" name="phone" class="form-control" value="<%= s.getPhone() %>" required>
    </div>

    <div class="mb-3">
      <label for="mail">Email</label>
      <input type="email" name="mail" class="form-control" value="<%= s.getMail() %>" required>
    </div>

    <div class="mb-3">
      <label for="branch">Branch</label>
      <input type="text" name="branch" class="form-control" value="<%= s.getBranch() %>" required>
    </div>

    <div class="mb-3">
      <label for="loc">Location</label>
      <input type="text" name="loc" class="form-control" value="<%= s.getLoc() %>" required>
    </div>

    <div class="text-center">
      <button type="submit" class="btn btn-primary">Update</button>
      <a href="dashboard.jsp" class="btn btn-secondary">Cancel</a>
    </div>
  </form>
</div>

</body>
</html>
