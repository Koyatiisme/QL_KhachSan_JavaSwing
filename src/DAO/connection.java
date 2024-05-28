package DAO;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//class connection để
//kết nối csdl 
//thực hiện các lệnh truy vấn 
//insert update delete
//select
public class connection {
//    tạo chuỗi hết nối

    private static final String DB_URL = "jdbc:sqlserver://localhost:2101;databaseName=QL_khachsan;user=sa;password=123456";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "123456";
    static Connection conn = null;


    public connection() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully");
        } catch (ClassNotFoundException ex) {
            System.out.println("loi thieu thu vien");
        } catch (SQLException ex) {
            System.out.println("connect unsuccessfully error: False sql");
        }

    }


    //hàm thực thi câu lệnh select
    public static ResultSet Getdata(String cauTruyVan){
        try {
            Statement stm=conn.createStatement();
            //thực thicaau truy vấn select dc truyền vào từ
            //tham số cautruyvan
            //trả về kết quả là ResultSet
            ResultSet rs=stm.executeQuery(cauTruyVan);
            return rs;//trả về resultset nếu thành công
        } catch (SQLException ex) {
            System.out.println("lỗi truy vấn");
            return null;
        }
    
    }
    // hàm thực thi 3 câu lệnh insert delete update
    public static int ExecuteTruyVan(String cauTruyVan){
        try {
            Statement stm= conn.createStatement();
            return stm.executeUpdate(cauTruyVan);
            
        } catch (SQLException ex) {
            System.out.println("lỗi thực thi truy vấn");
            return -1;
        }
    }
    public static void main(String[] args) {
        
    }
}
