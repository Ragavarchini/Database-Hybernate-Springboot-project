<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cons.Patient" %>
<%@ page import="com.cons.Doctor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f9fc;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: auto;
        overflow: hidden;
    }
    header {
        background: #35424a;
        color: #ffffff;
        padding-top: 30px;
        min-height: 70px;
        border-bottom: #e8491d 3px solid;
    }
    header a {
        color: #ffffff;
        text-decoration: none;
        text-transform: uppercase;
        font-size: 16px;
    }
    header ul {
        padding: 0;
        list-style: none;
    }
    header li {
        float: left;
        display: inline;
        padding: 0 20px 0 20px;
    }
    .main-content {
        margin-top: 30px;
    }
    table {
        width: 100%;
        margin-top: 20px;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid #dddddd;
    }
    th, td {
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Admin Panel</h1>
            <nav>
                <ul>
                    <li><a href="AdminServlet?action=viewDoctors">View Doctors</a></li>
                    <li><a href="AdminServlet?action=viewPatients">View Patients</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="container main-content">
        <h2>Manage Doctors and Patients</h2>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p style="color: red;"><%= error %></p>
        <%
            }
        %>
        <%
            ArrayList<Doctor> doctors = (ArrayList<Doctor>) request.getAttribute("doctors");
            if (doctors != null) {
        %>
            <h3>Doctors</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Gender</th>
                    <th>Experience</th>
                </tr>
                <%
                    for (Doctor doctor : doctors) {
                %>
                <tr>
                    <td><%= doctor.getId() %></td>
                    <td><%= doctor.getName() %></td>
                    <td><%= doctor.getAddress() %></td>
                    <td><%= doctor.getGender() %></td>
                    <td><%= doctor.getExperience() %></td>
                </tr>
                <%
                    }
                %>
            </table>
        <%
            }
        %>
        <%
            ArrayList<Patient> patients = (ArrayList<Patient>) request.getAttribute("patients");
            if (patients != null) {
        %>
            <h3>Patients</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Gender</th>
                </tr>
                <%
                    for (Patient patient : patients) {
                %>
                <tr>
                    <td><%= patient.getId() %></td>
                    <td><%= patient.getName() %></td>
                    <td><%= patient.getAddress() %></td>
                    <td><%= patient.getGender() %></td>
                </tr>
                <%
                    }
                %>
            </table>
        <%
            }
        %>
    </div>
</body>
</html>
