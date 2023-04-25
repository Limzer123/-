package Servlet;
 
import Utils.UserDao;
import Utils.UserDaoImpl;
import Utils.User;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
 

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
 
        //转换字符串
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        //调用UserDao、UserDaoImpl类及方法
        UserDao ud = new UserDaoImpl();
        User u = new User();
 
        //添加用户提交的数据到数据库
        u.setUsername(username);
        u.setPassword(password);
 
        //处理结果跳转相应页面
        boolean flag = ud.save(u);
        if(flag){
            //注册成功后跳转
            response.sendRedirect("registersuccess.jsp");
        }else{
            response.sendRedirect("register.jsp");
        }
 
 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

