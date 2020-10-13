package repositories.JPA;

import domain.Borrow;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BorrowJPARepository {


    @PersistenceContext(unitName = "gamesPersistenceUnit")//TRAINER: watch out for typos in your unitname
    private EntityManager entityManager;

    public List<Borrow> findAllBorrow(){
        return entityManager
                .createQuery("SELECT b FROM Borrow b", Borrow.class)
                .getResultList();
    }
}
