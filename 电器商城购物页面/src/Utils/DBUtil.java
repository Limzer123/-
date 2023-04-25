package Utils;
 
import java.sql.*;
 
public class DBUtil {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=electricmall";
    private static String user = "sa";
    private static String pwd = "20011020lizhi";
 
    //��������
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    //���Ӷ���
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
 
    //�ر���
    public static void close(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void close(PreparedStatement pst, Connection conn){
        close(null, pst, conn);
    }
}
