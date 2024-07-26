<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Registration Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f9fc;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .form-container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        width: 50%;
        max-width: 600px;
    }
    .form-container h1 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 20px;
    }
    .form-container table {
        width: 100%;
    }
    .form-container td {
        padding: 10px;
        vertical-align: top;
    }
    .form-container input[type="text"], .form-container input[type="date"], .form-container input[type="file"] {
        width: calc(100% - 20px);
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .form-container input[type="radio"] {
        margin-right: 10px;
    }
    .form-container input[type="submit"] {
        background-color: #3498db;
        color: white;
        border: none;
        padding: 12px 20px;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
        display: block;
        margin: 20px auto 0;
    }
    .form-container input[type="submit"]:hover {
        background-color: #2980b9;
    }
    .form-container b {
        color: #34495e;
    }
</style>
</head>
<body>
<div class="form-container">
    <h1>Patient Registration Form</h1>
    <form action="PatientContoller" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td colspan="2"><b>Basic Information</b></td>
            </tr>
            <tr>
                <td>Patient Name:</td>
                <td><input type="text" name="pname" required></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" required></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male" required> Male
                    <input type="radio" name="gender" value="Female"> Female
                    <input type="radio" name="gender" value="Others"> Others
                </td>
            </tr>
            <tr>
                <td>Prescription:</td>
                <td><input type="file" name="prescription"></td>
            </tr>
            <tr>
                <td colspan="2"><b>Appointment Information</b></td>
            </tr>
            <tr>
                <td>Required Appointment Date:</td>
                <td><input type="date" name="appdate" required></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
