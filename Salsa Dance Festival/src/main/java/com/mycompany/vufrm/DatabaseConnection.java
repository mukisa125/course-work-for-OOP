
package com.mycompany.vufrm; 


//this  import all necessary classes for working with SQL in Java
import java.sql.*;

public class DatabaseConnection {
    
    // A static variable to store the database connection (shared by all methods in this class)
    
    private static Connection con = null;
    
    // ===========================
    // Method to get a database connection
    // ===========================
    public static Connection getConnection() {
        try {
            // Check if the connection is null (not yet created) OR has been closed
            if (con == null || con.isClosed()) {
                
                // 1️⃣ Load the UCanAccess driver for Microsoft Access (.accdb)
                // This driver allows Java to communicate with Access databases
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                // 2️⃣ Define the path to your Access database file
                // ⚠️ Update this path if you move your database to a new location
                String dbPath = "jdbc:ucanaccess://C:\\Users\\Mukisa\\Documents\\NetBeansProjects\\vufrm\\database\\VUE_Exhibition.accdb";
                
                // 3️⃣ Create a connection to the database using the path above
                con = DriverManager.getConnection(dbPath);
                
                // 4️⃣ Print a confirmation message if successful
                System.out.println("Database connected successfully!");
            }
        } catch (Exception e) {
            // Catch *any* error during connection (like missing driver or wrong path)
            System.out.println("Database connection failed: " + e.getMessage());
            
            // Print full error details (for debugging)
            e.printStackTrace();
        }
        
        // Return the connection object (may be new or existing)
        return con;
    }
    
    // ===========================
    // Method to close the connection safely
    // ===========================
    public static void closeConnection() {
        try {
            // Check if there is an active connection before trying to close it
            if (con != null && !con.isClosed()) {
                
                // Close the connection to free up system resources
                con.close();
                System.out.println("Database connection closed successfully!");
            }
        } catch (SQLException e) {
            // Handle any SQL-related error that may occur while closing
            e.printStackTrace();
        }
    }
}
