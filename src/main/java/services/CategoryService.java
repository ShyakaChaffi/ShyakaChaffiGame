package services;

import domain.Category;
import repositories.JPA.CategoryJPARepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CategoryService {
    //    private CategoryJDBCRepository categoryJDBCRepository = CategoryJDBCRepository.getInstance();
    @Inject
    CategoryJPARepository categoryJPARepository;

    public Category findGameCategoryById(int id) {
//        return categoryJDBCRepository.getGameCategory(id);
        return categoryJPARepository.findCategoryById(id);
    }
}