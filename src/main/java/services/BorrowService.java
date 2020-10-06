package services;

import domain.Borrow;
import repositories.JDBC.BorrowJDBCRepository;

import java.util.List;

public class BorrowService {
    private BorrowJDBCRepository borrowJDBCRepository = BorrowJDBCRepository.getInstance();

    public List<Borrow> findAllBorrow() {
        return borrowJDBCRepository.getAllBorrow();
    }
}
