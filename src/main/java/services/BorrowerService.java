package services;

import domain.Borrower;
import repositories.JDBC.BorrowerJDBCRepository;

public class BorrowerService {
    private BorrowerJDBCRepository borrowerJDBCRepository = BorrowerJDBCRepository.getInstance();

    public Borrower findBorrowerById(int id){
        return borrowerJDBCRepository.getBorrower(id);
    }
}
