package Utils;
 
import Utils.User;
 
public interface UserDao {
    //��������������ķ���
    public boolean save(User user);
    public boolean checkLogin(String username, String password);
}
