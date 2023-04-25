package Utils;
 
import java.sql.*;
 
public class JDBCUtils {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=electricmall";
    private static String user = "sa";
    private static String pwd = "20011020lizhi";
 
    //加载驱动
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    //连接对象
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
 

    public static void Close(ResultSet resultSet, PreparedStatement statement,Connection connection) throws SQLException {
        if(resultSet != null)
            resultSet.close();
        if(statement != null)
            statement.close();
        if(connection != null)
            connection.close();
    }
}
