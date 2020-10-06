package repositories.JDBC;

import domain.Borrow;
import domain.Borrower;
import domain.Game;
import repositories.utils.JDBCConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowJDBCRepository {

    private static final BorrowJDBCRepository instance = new BorrowJDBCRepository();

    public static BorrowJDBCRepository getInstance() {
        return instance;
    }

    public List<Borrow> getAllBorrow() {
        List<Borrow> borrows = new ArrayList<Borrow>();
        try (PreparedStatement preparedStatement = JDBCConnector.createConnection().prepareStatement("select * from Borrow as b " +
                "LEFT OUTER JOIN Game as g ON g.id = b.game_id " +
                "LEFT OUTER JOIN Borrower as b2 ON b2.id = b.borrower_id ")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                Game game = new Game.Builder(resultSet.getString("g.game_name")).build();
                Borrower borrower = new Borrower(resultSet.getString("b2.borrower_name"));
                Borrow borrow = new Borrow(resultSet.getInt("id"), game, borrower, resultSet.getDate("borrow_date"), resultSet.getDate("return_date"));
                borrows.add(borrow);
            }

            borrows = borrows.stream()
                    .sorted(Comparator.comparing(Borrow::getBorrow_date))
                    .sorted((b1, b2) -> b1.getBorrower_id().getBorrower_name().compareToIgnoreCase(b2.getBorrower_id().getBorrower_name()))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrows;
    }
}
