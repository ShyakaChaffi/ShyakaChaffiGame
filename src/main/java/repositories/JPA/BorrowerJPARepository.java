package repositories.JPA;


import domain.Borrower;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Stateless
public class BorrowerJPARepository {
    @PersistenceContext(unitName = "gamesPersistenceUnit") //TRAINER: watch out for typos in your unitname
    private EntityManager entityManager;

    public Borrower findBorrowerById(int id){
        return entityManager
                .createQuery("SELECT b FROM Borrower b WHERE b.Id = :id", Borrower.class)
                .setParameter("id", id)
                .setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT) //TRAINER: also don't forget to add a version field in Borrower and annotate it with @Version
                .getSingleResult();
    }

}
