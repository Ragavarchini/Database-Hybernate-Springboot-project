<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Our Healthcare Portal</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        margin: 0;
        padding: 0;
    }
    .container {
        text-align: center;
        padding: 50px;
    }
    h1 {
        color: #2c3e50;
    }
    .button-container {
        margin-top: 30px;
    }
    .button {
        background-color: #3498db;
        color: white;
        border: none;
        padding: 15px 30px;
        text-decoration: none;
        font-size: 18px;
        border-radius: 5px;
        margin: 10px;
        cursor: pointer;
    }
    .button:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Our Healthcare Portal</h1>
        <p>Your health is our priority. Please choose an option below to proceed:</p>
        <div class="button-container">
            <a href="patientregform.jsp" class="button"> Patient Registration Form</a>
            <a href="doctorregform.jsp" class="button"> Doctor Registration Form</a>
            <a href="Admin.jsp" class="button">Admin Panel</a>
        </div>
    </div>
</body> 
</html>
