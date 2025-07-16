<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pentagon Space - Application Form</title>
    <style>
  body {
      margin: 0;
      padding: 0;
      height: 120vh;
      font-family: 'Segoe UI', sans-serif;
      background: url('pentagon.png') no-repeat center center fixed;
      background-size: 900px; /* FULL screen for visible blur */
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .container {
      background: rgba(255, 255, 255, 0.1);
      backdrop-filter: blur(4px);
      -webkit-backdrop-filter: blur(8px);
      padding: 40px 30px;
      border-radius: 15px;
      box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
      width: 360px;
      color: black;
    }

    h2, h4 {
      text-align: center;
      margin: 0;
    }

    h4 {
      margin-bottom: 20px;
      font-weight: normal;
    }

    label {
      display: block;
      margin-top: 15px;
      font-weight: bold;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
      width: 100%;
      padding: 10px;
      margin-top: 6px;
      border-radius: 6px;
      border: 1px solid rgba(255, 255, 255, 0.3);
      background: rgba(255, 255, 255, 0.1);
      color: black;
      font-size: 14px;
      outline: none;
    }

    input::placeholder {
      color: rgba(255, 255, 255, 0.7);
    }

    .btn {
      width: 100%;
      background-color: #00b894;
      color: white;
      padding: 12px;
      border: none;
      border-radius: 6px;
      margin-top: 20px;
      font-size: 16px;
      cursor: pointer;
      font-weight: bold;
    }

    .btn:hover {
      background-color: #019875;
    }

    .login-link {
      text-align: center;
      margin-top: 15px;
      color: #fff;
    }

    .login-link a {
      color: black;
      text-decoration: none;
      font-weight: bold;
    }

    .login-link a:hover {
      text-decoration: underline;
    }
  
  </style>
</head>
<body>
    <div class="container">
        <h2>Pentagon Space</h2>
        <h4>Application form</h4>
        <form action="signUp" method="post">
            <label>Enter your Name:</label>
            <input type="text" name="name" required>

            <label>Enter the Phone number:</label>
            <input type="text" name="phone" required>

            <label>Enter the Mail ID:</label>
            <input type="email" name="mail" required>

            <label>Enter the Branch:</label>
            <input type="text" name="branch" required>

            <label>Enter the Location:</label>
            <input type="text" name="loc" required>

            <label>Enter the password:</label>
            <input type="password" name="password" required>

            <label>Confirm the password:</label>
            <input type="password" name="confirm" required>

            <button type="submit" class="btn">create account</button>

            <div class="login-link">
                already have a account? <a href="Login.jsp">login</a>
            </div>
        </form>
    </div>
</body>
</html>