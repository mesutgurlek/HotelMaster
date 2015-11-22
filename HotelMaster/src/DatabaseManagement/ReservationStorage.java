package DatabaseManagement;

import HotelEntities.Reservation;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Heaven on 11/6/2015.
 */
public class ReservationStorage {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hotelmaster";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public ArrayList<Reservation> getReservations(){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement query = null;
        ArrayList<Reservation> reservations = new ArrayList<>();
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // Now you can extract all the records
            // to see the remaining records
            String sql = "SELECT name, phoneNo, roomNo, arrivalDate, departureDate, totalCost FROM reservationstorage";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                String name  = rs.getString("name");
                String phoneNo  = rs.getString("phoneNo");
                int roomNo = rs.getInt("roomNo");
                Date arrivalDate = rs.getDate("arrivalDate");
                Date departureDate = rs.getDate("departureDate");
                double totalCost = rs.getDouble("totalCost");

                //Display values
                Reservation reservation = new Reservation(name, roomNo, arrivalDate, departureDate,phoneNo, totalCost);
                reservations.add(reservation);
                System.out.print("name: " + name);
                System.out.print(", phone: " + phoneNo);
                System.out.print(", room: " + roomNo);
                System.out.print(", arrival date: " + arrivalDate);
                System.out.print(", departure date: " + departureDate);
                System.out.println(", totalCost: " + totalCost);
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return reservations;
    }

    public void insertReservation(String name, String phoneNo, int roomNo, Date arrivalDate, Date departureDate, double totalCost){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement query = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            String str = "insert into reservationstorage values (?, ?, ?, ?, ?, ?)";
            query = conn.prepareStatement(str);
            query.setString(1, name);
            query.setString(2, phoneNo);
            query.setInt(3, roomNo);
            query.setDate(4, arrivalDate);
            query.setDate(5, departureDate);
            query.setDouble(6, totalCost);

            query.executeUpdate();
            System.out.println("Inserted records into the table...");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public void deleteReservation(int roomNo){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement query = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            String str = "DELETE FROM reservationstorage WHERE roomNo = ?";
            query = conn.prepareStatement(str);
            query.setInt(1, roomNo);

            query.executeUpdate();
            System.out.println("Inserted records into the table...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}
