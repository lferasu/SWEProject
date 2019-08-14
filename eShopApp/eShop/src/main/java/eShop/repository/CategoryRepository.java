package eShop.repository;

import eShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
