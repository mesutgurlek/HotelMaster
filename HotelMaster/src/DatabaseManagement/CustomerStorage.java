package DatabaseManagement;

import HotelEntities.Customer;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Heaven on 11/6/2015.
 */
public class CustomerStorage {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hotelmaster";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public ArrayList<Customer> getCustomers(){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement query = null;
        ArrayList<Customer> customers = new ArrayList<>();
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
            String sql = "SELECT name, phoneNo, purchaseType, roomNo, arrivalDate, departureDate, totalCost FROM customerstorage";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                String name  = rs.getString("name");
                String phoneNo  = rs.getString("phoneNo");
                String purchaseType  = rs.getString("purchaseType");
                int roomNo = rs.getInt("roomNo");
                Date arrivalDate = rs.getDate("arrivalDate");
                Date departureDate = rs.getDate("departureDate");
                double totalCost = rs.getDouble("totalCost");

                //Display values
                Customer customer = new Customer(name, roomNo, purchaseType,arrivalDate, departureDate, totalCost, phoneNo);
                customers.add(customer);
                System.out.print("name: " + name);
                System.out.print(", phone: " + phoneNo);
                System.out.print(", purchaseType: " + purchaseType);
                System.out.print(", room: " + roomNo);
                System.out.print(", arrival date: " + arrivalDate);
                System.out.print(", departure date: " + departureDate);
                System.out.println(", totalCost: " + totalCost);
            }
            rs.close();
            return customers;
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
        return customers;
    }

    public void insertCustomer(String name,  String phoneNo, String purchaseType, int roomNo, Date arrivalDate, Date departureDate, double totalCost){
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
            String str = "insert into customerstorage values (?, ?, ?, ?, ?, ?, ?)";
            query = conn.prepareStatement(str);
            query.setString(1, name);
            query.setString(2, phoneNo);
            query.setString(3, purchaseType);
            query.setInt(4, roomNo);
            query.setDate(5, arrivalDate);
            query.setDate(6, departureDate);
            query.setDouble(7, totalCost);

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

    public void deleteCustomer(int roomNo){
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
            String str = "DELETE FROM customerstorage WHERE roomNo = ?";
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
