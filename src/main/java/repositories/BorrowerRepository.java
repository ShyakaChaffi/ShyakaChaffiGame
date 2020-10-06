package repositories;

import domain.Borrower;
import domain.Category;

import java.sql.*;

public class BorrowerRepository {

    public static final BorrowerRepository instance= new BorrowerRepository();

    public static BorrowerRepository getInstance() {
        return instance;
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

    public Borrower getfirstBorrower() throws SQLException { // READ
        Borrower borrower= new Borrower();
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from borrower LIMIT 1")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                borrower.setId(resultSet.getInt("id"));
                borrower.setBorrower_name(resultSet.getString("borrower_name"));
                borrower.setBus_number(resultSet.getString("bus_number"));
                borrower.setStreet(resultSet.getString("street"));
                borrower.setHouse_number(resultSet.getString("house_number"));
                borrower.setPostcode(resultSet.getInt("postcode"));
                borrower.setCity(resultSet.getString("city"));
                borrower.setTelephone(resultSet.getString("telephone"));
                borrower.setEmail(resultSet.getString("email"));

            }
            return borrower;
        }
    }
}
