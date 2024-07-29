package com.cons;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:mysql://localhost:3307/hospital";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if ("viewDoctors".equals(action)) {
                ArrayList<Doctor> doctors = new ArrayList<>();
                String sql = "SELECT * FROM doctordata";
                try (PreparedStatement pst = con.prepareStatement(sql);
                     ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setId(rs.getInt("id"));
                        doctor.setName(rs.getString("dname"));
                        doctor.setAddress(rs.getString("address"));
                        doctor.setGender(rs.getString("gender"));
                        doctor.setExperience(rs.getInt("experience"));
                        doctors.add(doctor);
                    }
                }
                request.setAttribute("doctors", doctors);
                getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
            } else if ("viewPatients".equals(action)) {
                ArrayList<Patient> patients = new ArrayList<>();
                String sql = "SELECT * FROM patientdata";
                try (PreparedStatement pst = con.prepareStatement(sql);
                     ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        Patient patient = new Patient();
                        patient.setId(rs.getInt("id"));
                        patient.setName(rs.getString("pname"));
                        patient.setAddress(rs.getString("address"));
                        patient.setGender(rs.getString("gender"));
                        patients.add(patient);
                    }
                }
                request.setAttribute("patients", patients);
                getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if necessary
    }
}
