<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Forgot Password - Pentagon Space</title>
  
  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
  
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }

    body {
      height: 100vh;
      background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
        url('https://images.unsplash.com/photo-1596495577886-d920f1fb7238?auto=format&fit=crop&w=1470&q=80') 
        no-repeat center center/cover;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .forgot-card {
      background: rgba(255, 255, 255, 0.15);
      box-shadow: 0 8px 32px rgba(0, 0, 0, 0.37);
      backdrop-filter: blur(10px);
      -webkit-backdrop-filter: blur(10px);
      border-radius: 15px;
      padding: 40px;
      width: 90%;
      max-width: 400px;
      color: #fff;
    }

    .forgot-card h2 {
      text-align: center;
      margin-bottom: 25px;
      font-size: 26px;
      color: #ffffff;
    }

    label {
      display: block;
      margin-top: 15px;
      font-weight: 500;
    }

    input {
      width: 100%;
      padding: 12px;
      margin-top: 5px;
      border: none;
      border-radius: 10px;
      background: rgba(255, 255, 255, 0.25);
      color: #fff;
      outline: none;
    }

    input::placeholder {
      color: #e0e0e0;
    }

    button {
      width: 100%;
      margin-top: 25px;
      padding: 12px;
      border: none;
      border-radius: 10px;
      background: linear-gradient(to right, #36d1dc, #5b86e5);
      color: white;
      font-size: 16px;
      font-weight: bold;
      cursor: pointer;
      transition: 0.3s;
    }

    button:hover {
      opacity: 0.9;
    }

    .back-link {
      text-align: center;
      margin-top: 15px;
      font-size: 14px;
    }

    .back-link a {
      color: #ffffff;
      text-decoration: underline;
    }

    @media screen and (max-width: 500px) {
      .forgot-card {
        padding: 25px;
      }

      .forgot-card h2 {
        font-size: 22px;
      }
    }
  </style>
</head>
<body>
  <div class="forgot-card">
    <h2>🔒 Forgot Password</h2>
    <form action="resetPassword" method="post">
      <label for="phone">Phone Number</label>
      <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required>

      <label for="mail">Email</label>
      <input type="email" id="mail" name="mail" placeholder="Enter your email" required>

      <label for="newPassword">New Password</label>
      <input type="password" id="newPassword" name="newPassword" placeholder="Enter new password" required>

      <label for="confirmPassword">Confirm Password</label>
      <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Re-enter new password" required>

      <button type="submit">Reset Password</button>

      <div class="back-link">
        <a href="Login.jsp">← Back to Login</a>
      </div>
    </form>
  </div>
</body>
</html>
    