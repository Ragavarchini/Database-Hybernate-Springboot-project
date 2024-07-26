package com.cons;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class PatientContoller
 */
@WebServlet("/PatientContoller")
@MultipartConfig(maxFileSize = 33333333)
public class PatientContoller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:mysql://localhost:3307/hospital";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String pname = request.getParameter("pname");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        InputStream istrm = null;

        // Handle file upload
        Part fp = request.getPart("prescription");
        if (fp != null) {
            System.out.println("File Name: " + fp.getName());
            System.out.println("File Size: " + fp.getSize());
            System.out.println("Content Type: " + fp.getContentType());
            istrm = fp.getInputStream();
        }

        // Database connection and SQL execution
        String msg = null;
        try {
            // Optional driver registration
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                String sql = "INSERT INTO patientdata (pname, address, gender, prescription) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, pname);
                    pst.setString(2, address);
                    pst.setString(3, gender);
                    if (istrm != null) {
                        pst.setBlob(4, istrm);
                    } else {
                        pst.setNull(4, java.sql.Types.BLOB);
                    }
                    int res = pst.executeUpdate();
                    msg = (res > 0) ? "Data uploaded successfully" : "Data upload failed";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "Database error: " + e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            msg = "JDBC Driver not found: " + e.getMessage();
        }

        // Forward to the message page
        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
    }
}