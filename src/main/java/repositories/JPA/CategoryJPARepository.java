package repositories.JPA;

import domain.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryJPARepository {

    @PersistenceContext(unitName = "gamePersistenceUnit")
    private EntityManager entityManager;

    public Category findCategoryById(int id){
        return entityManager
                .createQuery("SELECT c FROM Category c WHERE c.Id = :id", Category.class)
                .setParameter("id", id)
                .setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
                .getSingleResult();
    }
}
