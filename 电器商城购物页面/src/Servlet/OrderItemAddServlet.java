package Servlet;

import Utils.ProductRepository;
import Utils.ProductRepositoryImpl;
import Utils.OrderItem;
import Utils.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addOrderItem")
public class OrderItemAddServlet extends HttpServlet {
    private ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        String type = req.getParameter("type");
        Product product = productRepository.getProductById(pid);

        OrderItem orderItem = new OrderItem(product,num);
        List<OrderItem> list = (List<OrderItem>) req.getSession().getAttribute("ois");

        if(list == null){
            list = new ArrayList<OrderItem>();
            req.getSession().setAttribute("ois",list);
        }
        //检查是否有重复的数量
        boolean flag = false;
        for(OrderItem o : list){
            if(o.getProduct().getId() == product.getId()){
                o.setNum(o.getNum() + num);
                flag = true;
                break;
            }
        }
        if(!flag)
        list.add(orderItem);
        
        resp.sendRedirect("cartlist.jsp");
    }
}
