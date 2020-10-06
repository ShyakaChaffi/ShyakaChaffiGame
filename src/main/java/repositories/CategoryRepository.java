package repositories;

import domain.Category;

import java.sql.*;

public class CategoryRepository {

    public static final CategoryRepository categoryRepository= new CategoryRepository();

    public static CategoryRepository getInstance() {
        return categoryRepository;
    }


    public Connection createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/games"
                , "root"
                , "");
    }

    public Category getfirstCategory() throws SQLException { // READ
        Category category= new Category();
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from category LIMIT 1")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                category.setId(resultSet.getInt("id"));
                category.setCategory_name(resultSet.getString("category_name"));
                System.out.println(category.getCategory_name());

            }
            return category;
        }
    }

}
