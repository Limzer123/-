package Utils;
 
import Utils.JDBCUtils;
 
import java.sql.Connection;
 
public class JDBCTest {
    public static void main(String[] args) {
        //�����������ݿ��Ƿ�ɹ�
        Connection conn = DBUtil.getConnection();
        if(conn != null){
            System.out.println("���ԣ����ݿ����ӳɹ���");
        }else{
            System.out.println("���ԣ����ݿ�����ʧ�ܣ�");
        }
    }
}
