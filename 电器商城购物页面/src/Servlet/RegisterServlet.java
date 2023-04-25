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
        //�����ַ�
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
 
        //ת���ַ���
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        //����UserDao��UserDaoImpl�༰����
        UserDao ud = new UserDaoImpl();
        User u = new User();
 
        //����û��ύ�����ݵ����ݿ�
        u.setUsername(username);
        u.setPassword(password);
 
        //��������ת��Ӧҳ��
        boolean flag = ud.save(u);
        if(flag){
            //ע��ɹ�����ת
            response.sendRedirect("registersuccess.jsp");
        }else{
            response.sendRedirect("register.jsp");
        }
 
 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

