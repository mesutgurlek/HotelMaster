package DatabaseManagement;

import HotelEntities.Room;
import HotelEntities.RoomStatus;
import HotelEntities.RoomType;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Heaven on 11/6/2015.
 */
public class RoomStorage {
    //Enumeration for room types and Room Status
    public enum types{regular, family, king};
    public enum status{full, empty, reserved};

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hotelmaster";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public RoomType typeConverter(String type){
        if( type.equals("king")){
            return RoomType.king;
        }
        else if( type.equals("family") ){
            return RoomType.family;
        }
        else if( type.equals("regular") ){
            return RoomType.regular;
        }
        else{
            return null;
        }
    }
    public RoomStatus statusConverter(String stat){
        if( stat.equals("empty")){
            return RoomStatus.empty;
        }
        else if( stat.equals("full") ){
            return RoomStatus.full;
        }
        else if( stat.equals("reserved") ){
            return RoomStatus.reserved;
        }
        else{
            return null;
        }
    }

    public ArrayList<Room> getRooms(){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement query = null;
        ArrayList<Room> rooms = new ArrayList<>();
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
            String sql = "SELECT roomNo, roomType, status, floorNo, adultCount, childCount, dailyPrice, extraInfo FROM roomstorage";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int roomNo  = rs.getInt("roomNo");
                String type = rs.getString("roomType");
                String stat = rs.getString("status");
                int floor = rs.getInt("floorNo");
                int adultCnt = rs.getInt("adultCount");
                int childCnt = rs.getInt("childCount");
                double dailyPrice = rs.getDouble("dailyPrice");
                String extraInfo = rs.getString("extraInfo");

                //Display values
                Room room = new Room(roomNo, floor, typeConverter(type), statusConverter(stat), dailyPrice, childCnt, adultCnt, extraInfo);
                rooms.add(room);
                System.out.print("roomNo: " + roomNo);
                System.out.print(", RoomType: " + type);
                System.out.print(", status: " + stat);
                System.out.print(", floor: " + floor);
                System.out.print(", adultCnt: " + adultCnt);
                System.out.print(", childCnt: " + childCnt);
                System.out.print(", dailyPrice: " + dailyPrice);
                System.out.println(", extraInfo: " + extraInfo);
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
        return rooms;
    }

    public void insertRoom(int roomNo, String roomType, String roomStat, int floorNo, int adultCount, int childCount, double dailyPrice, String extraInfo){
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
            String str = "insert into roomstorage values (?, ?, ?, ?, ?, ?, ?, ?)";
            query = conn.prepareStatement(str);
            query.setInt(1, roomNo);
            query.setString(2, roomType);
            query.setString(3, roomStat);
            query.setInt(4, floorNo);
            query.setInt(5, adultCount);
            query.setInt(6, childCount);
            query.setDouble(7, dailyPrice);
            query.setString(8, extraInfo);

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

    public void deleteRoom(int roomNo){
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
            String str = "DELETE FROM roomstorage WHERE roomNo = ?";
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
