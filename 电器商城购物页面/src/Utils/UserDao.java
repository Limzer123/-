package Utils;
 
import Utils.User;
 
public interface UserDao {
    //定义两个待解决的方法
    public boolean save(User user);
    public boolean checkLogin(String username, String password);
}
