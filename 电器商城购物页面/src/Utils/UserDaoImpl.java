package Utils;
 
import Utils.DBUtil;
import Utils.UserDao;
import Utils.User;
 
import java.sql.*;
 
 
 
//ʵ�ֽӿڵ��࣬����ֵΪ��������
public class UserDaoImpl implements UserDao {
    public boolean save(User user){
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pst = null;
 
        /*
        ��������Connection�����Statement����
        ���ò������ݵ����ݿ�ķ���
        */
        conn = DBUtil.getConnection();
        String sql = "insert into [user] (username, password) values(?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            int row = pst.executeUpdate();
            if(row>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(pst, conn);
        }
        return flag;
    }
 
    public boolean checkLogin(String username, String password){
        boolean flag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        /*
        ����Connnection, Statement, ResultSet����
        ������֤��¼�ķ���
        */
        String sql ="select * from [user] where username = '"+ username +"'";
        conn = DBUtil.getConnection();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                if(rs.getString("password").equals(password)){
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, st, conn);
        }
        return flag;
    }
}
