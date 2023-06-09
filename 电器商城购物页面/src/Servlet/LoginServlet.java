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
 
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
 
        //转换字符串
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        //调用UserDao、UserDaoImpl类及方法
        UserDao ud = new UserDaoImpl();
 
        //处理结果跳转相应页面
        boolean flag = ud.checkLogin(username, password);
        if(flag){
            //将提交的用户名存入session，前台登录成功页面调取
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
 
            //登录成功后跳转
            response.sendRedirect("loginsuccess.jsp");
        }else{
            response.sendRedirect("loginfailed.jsp");
        }
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
