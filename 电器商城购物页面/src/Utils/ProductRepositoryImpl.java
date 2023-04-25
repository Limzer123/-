package Utils;

import Utils.ProductRepository;
import Utils.Product;
import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> returnProduct() {
        List<Product> list = new ArrayList<Product>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from cart..product order by id";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                list.add(new Product(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getFloat("price")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.Close(resultSet,statement,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from cart..product where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                product = new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getFloat(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
}


